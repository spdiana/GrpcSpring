package com.grpc.server;

import com.google.common.util.concurrent.ListenableFuture;
import com.grpc.*;
import com.grpc.server.model.WalletEntity;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.*;
import org.junit.runner.RunWith;
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WalletServerMain.class}, webEnvironment = NONE, properties = "grpc.port=7777")
@ActiveProfiles(profiles = {"customServerBuilder"})
public class WalletServiceGrpcTest {


    private static boolean initialized = false;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private ManagedChannel channel;

    private long userID = 1;

    @Autowired
    private GRpcServerBuilderConfigurer configurer;
    @Autowired
    private WalletRepository walletRepository;

    @Before
    public void setup() {
        channel = ManagedChannelBuilder.forAddress("localhost", 7777)
                .usePlaintext(true)
                .build();

        if (!initialized) {
            WalletEntity wallet1 = new WalletEntity(userID, Currency.USD.name(), 0.0);
            WalletEntity wallet2 = new WalletEntity(userID, Currency.EUR.name(), 0.0);
            WalletEntity wallet3 = new WalletEntity(userID, Currency.GBP.name(), 0.0);
            walletRepository.save(wallet1);
            walletRepository.save(wallet2);
            walletRepository.save(wallet3);
            initialized = true;
        }
    }

    @After
    public void tearDown() {
        walletRepository.truncateTable();
        if (channel != null) {
            channel.shutdownNow();
        }

    }

    @Test
    public void serverBuilderTest () throws Exception {
        WalletRequest walletRequest;

        ListenableFuture<WalletResponse> walletResponseListener;
        ListenableFuture<BalanceResponse> balanceListener ;

        BalanceRequest balanceRequest;
        BalanceResponse balandeResponse;

        double balanceUSD;
        double balanceEUR;
        double balanceGBP;


        //1.	Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(200.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(walletRequest);

        try {
            walletResponseListener.get();
        } catch (ExecutionException e) {
            Assert.assertEquals("io.grpc.StatusRuntimeException: NOT_FOUND: Funds Not enough to Withdraw - User ID: " + userID, e.getMessage());
        }


        //2.    Make a deposit of USD 100 to user with id 1.
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(100.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).deposit(walletRequest);
        walletResponseListener.get();

        //3.    Check that all balances are correct

        balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();
        balanceListener = WalletServiceGrpc.newFutureStub(channel).balance(balanceRequest);
        balandeResponse = balanceListener.get();
        balanceUSD = balandeResponse.getBalanceByCurrencyOrThrow(Currency.USD.name());
        balanceEUR = balandeResponse.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        balanceGBP = balandeResponse.getBalanceByCurrencyOrThrow(Currency.GBP.name());

        Assert.assertEquals(balanceUSD, 100.0, 0);
        Assert.assertEquals(balanceEUR, 0, 0);
        Assert.assertEquals(balanceGBP, 0, 0);


        //4.    Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(200.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(walletRequest);


        try {
            walletResponseListener.get();
        } catch (ExecutionException e) {
            Assert.assertEquals("io.grpc.StatusRuntimeException: NOT_FOUND: Funds Not enough to Withdraw - User ID: " + userID, e.getMessage());
        }


        //5.    Make a deposit of EUR 100 to user with id 1.
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(100.0)
                .setCurrency(Currency.EUR)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).deposit(walletRequest);
        walletResponseListener.get();


        //6.    Check that all balances are correct
        balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();
        balanceListener = WalletServiceGrpc.newFutureStub(channel).balance(balanceRequest);
        balandeResponse = balanceListener.get();
        balanceUSD = balandeResponse.getBalanceByCurrencyOrThrow(Currency.USD.name());
        balanceEUR = balandeResponse.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        balanceGBP = balandeResponse.getBalanceByCurrencyOrThrow(Currency.GBP.name());

        Assert.assertEquals(balanceUSD, 100.0, 0);
        Assert.assertEquals(balanceEUR, 100.0, 0);
        Assert.assertEquals(balanceGBP, 0, 0);


        //7.    Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(200.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(walletRequest);

        try {
            walletResponseListener.get();
        } catch (ExecutionException e) {
            Assert.assertEquals("io.grpc.StatusRuntimeException: NOT_FOUND: Funds Not enough to Withdraw - User ID: " + userID, e.getMessage());
        }


        //8.    Make a deposit of USD 100 to user with id 1.
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(100.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).deposit(walletRequest);
        walletResponseListener.get();


        //9.    Check that all balances are correct
        balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();
        balanceListener = WalletServiceGrpc.newFutureStub(channel).balance(balanceRequest);
        balandeResponse = balanceListener.get();
        balanceUSD = balandeResponse.getBalanceByCurrencyOrThrow(Currency.USD.name());
        balanceEUR = balandeResponse.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        balanceGBP = balandeResponse.getBalanceByCurrencyOrThrow(Currency.GBP.name());

        Assert.assertEquals(balanceUSD, 200.0, 0);
        Assert.assertEquals(balanceEUR, 100.0, 0);
        Assert.assertEquals(balanceGBP, 0, 0);


        //10. Make a withdrawal of USD 200 for user with id 1. Must return "ok".
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(200.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(walletRequest);
        walletResponseListener.get();


        //11. Check that all balances are correct
        balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();
        balanceListener = WalletServiceGrpc.newFutureStub(channel).balance(balanceRequest);
        balandeResponse = balanceListener.get();
        balanceUSD = balandeResponse.getBalanceByCurrencyOrThrow(Currency.USD.name());
        balanceEUR = balandeResponse.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        balanceGBP = balandeResponse.getBalanceByCurrencyOrThrow(Currency.GBP.name());

        Assert.assertEquals(balanceUSD, 0, 0);
        Assert.assertEquals(balanceEUR, 100.0, 0);
        Assert.assertEquals(balanceGBP, 0, 0);


        //12. Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(200.0)
                .setCurrency(Currency.USD)
                .build();

        walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(walletRequest);

        try {
            walletResponseListener.get();
        } catch (ExecutionException e) {
            Assert.assertEquals("io.grpc.StatusRuntimeException: NOT_FOUND: Funds Not enough to Withdraw - User ID: " + userID, e.getMessage());
        }
    }
}
