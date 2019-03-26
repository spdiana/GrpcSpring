package com.grpc.client;


import com.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class SimpleTestClient {
    private static final Logger logger = LoggerFactory.getLogger(SimpleTestClient.class);

    private ManagedChannel channel;

    private WalletServiceGrpc.WalletServiceBlockingStub blockingStub;

    private long userID  = 1;

    public SimpleTestClient(String hostname, int port) {
        channel = ManagedChannelBuilder.forAddress(hostname, port).usePlaintext(true).build();
        blockingStub = WalletServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public void geAll() {
        AllWallet all = AllWallet.getDefaultInstance();

        Iterable<WalletRequest> entries = toIterable(blockingStub.all(all));
        logger.info("METHOD GET_ALL CALLED");
        entries.forEach(entity -> logger.info("Value:: " + entity.getUserId() + " " + entity.getCurrency() + " " + entity.getAmount()));
    }

    public void getBalanceByUser() {

        BalanceRequest balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();

        BalanceResponse bl = blockingStub.balance(balanceRequest);

        logger.info("METHOD GET_BALANCE CALLED");

        double r = bl.getBalanceByCurrencyCount();

        double balanceUSD = bl.getBalanceByCurrencyOrThrow(Currency.USD.name());
        logger.info("UserID: " + userID + " USD: " + balanceUSD);

        double balanceEUR = bl.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        logger.info("UserID: " + userID + "  " + balanceEUR);

        double balanceGBP = bl.getBalanceByCurrencyOrThrow(Currency.GBP.name());
        logger.info("UserID: " + userID + "  " + balanceEUR);

    }

    public void deposit() {
        WalletRequest transactionRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(100)
                .setCurrency(Currency.USD)
                .build();

        blockingStub.deposit(transactionRequest);
        logger.info("METHOD DEPOSIT CALLED");

    }

    public void withdraw() {
        WalletRequest transactionRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(100)
                .setCurrency(Currency.USD)
                .build();

        blockingStub.withdrawal(transactionRequest);

        logger.warn("METHOD WITHDRAW CALLED");
    }

    private static <T> Iterable<T> toIterable(final Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }

    public static void main(String[] args) throws Exception {

        SimpleTestClient client = new SimpleTestClient("localhost", 6565);

        try {
           //MUST HAVE USER_ID 1 AND ALL CURRENCIES ADDED TO THE DATABASE
           client.geAll();
           client.deposit();
           client.getBalanceByUser();
           client.withdraw();
           client.getBalanceByUser();
        } finally {
            client.shutdown();
        }
    }
}
