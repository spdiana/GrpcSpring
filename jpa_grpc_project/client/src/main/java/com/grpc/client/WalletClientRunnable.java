package com.grpc.client;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.grpc.*;
import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class WalletClientRunnable extends Thread{

    private static final Logger logger = LoggerFactory.getLogger(SimpleTestClient.class);

    //"Number of concurrent requests a user will make
    private int idThread;

    //Number of rounds each thread is executing
    private int roundsInput;

    private int userIdRound;
    private long userID = 1;

    private ManagedChannel channel;
    private WalletServiceGrpc.WalletServiceBlockingStub blockingStub;

    private Semaphore semaphore;




    public WalletClientRunnable(int idThread, Semaphore semaphore, int user, ManagedChannel channel, int roundsInput) {
        this.idThread = idThread;
        this.semaphore = semaphore;
        this.userIdRound = user;
        this.channel  = channel;
        this.roundsInput = roundsInput;
    }


    private void doProcess() {

        for (int x = 0; x < roundsInput; x++) {
            logger.info("USER ID: "+ userIdRound +" Thread: " + idThread + " processing" );
            try {
                Random random = new Random();
                int value = random.nextInt(3);
                switch (value) {
                    case 0:
                        roundA();
                        break;
                    case 1:
                        roundB();
                        break;
                    case 2:
                        roundC();
                        break;
                }
                Thread.sleep((long) (Math.random() * 10000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        try {

            semaphore.acquire();
            doProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void getBalance(Long userID) {
        logger.info("METHOD BALANCE CALLED");

        BalanceRequest balanceRequest = BalanceRequest.newBuilder().setUserId(userID).build();

        blockingStub = WalletServiceGrpc.newBlockingStub(channel);
        BalanceResponse bl = blockingStub.balance(balanceRequest);


        double balanceUSD = bl.getBalanceByCurrencyOrThrow(Currency.USD.name());
        logger.info("UserID: " + userID + " USD: " + balanceUSD);

        double balanceEUR = bl.getBalanceByCurrencyOrThrow(Currency.EUR.name());
        logger.info("UserID: " + userID + " EUR: " + balanceEUR);

        double balanceGBP = bl.getBalanceByCurrencyOrThrow(Currency.GBP.name());
        logger.info("UserID: " + userID + " GBP: " + balanceEUR);
    }


    private void withdrawl(Long userID, double amount, Currency currency) {
        logger.info("METHOD WITHDRAW CALLED");

        WalletRequest transactionRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(amount)
                .setCurrency(currency)
                .build();

        ListenableFuture<WalletResponse> walletResponseListener = WalletServiceGrpc.newFutureStub(channel).withdrawal(transactionRequest);

        Futures.addCallback(walletResponseListener, new FutureCallback<WalletResponse>() {
            @Override
            public void onSuccess(WalletResponse result) {
                logger.info("SUCCESSFUL WITHDRAWAL " + userIdRound);
            }

            @Override
            public void onFailure(Throwable t) {
                logger.error("WITHDRAWAL FAILED " + t.getMessage());
            }
        }, MoreExecutors.directExecutor());

    }

    private void deposit(Long userID, double amount, Currency currency) {
        logger.info("METHOD DEPOSIT CALLED");

        WalletRequest transactionRequest = WalletRequest.newBuilder()
                .setUserId(userID)
                .setAmount(amount)
                .setCurrency(currency)
                .build();

        ListenableFuture<WalletResponse> walletResponseListener = WalletServiceGrpc.newFutureStub(channel).deposit(transactionRequest);

        Futures.addCallback(walletResponseListener, new FutureCallback<WalletResponse>() {
            @Override
            public void onSuccess(WalletResponse result) {
                logger.info("SUCCESSFUL DEPOSIT " + userIdRound);
            }

            @Override
            public void onFailure(Throwable t) {
                logger.error("DEPOSIT FAILED " + t.getMessage());
            }
        }, MoreExecutors.directExecutor());

    }

    private void roundA() {
        logger.info("Round A");

        deposit(userID, 100.0, Currency.USD);

        withdrawl(userID, 200.0, Currency.USD);

        deposit(userID, 100.0, Currency.EUR);

        getBalance(userID);

        withdrawl(userID, 100.0, Currency.USD);

        getBalance(userID);

        withdrawl(userID, 100.0, Currency.USD);
    }

    private void roundB() {
        logger.info("Round B");

        withdrawl(userID, 100.0, Currency.GBP);

        deposit(userID, 300.0, Currency.GBP);

        withdrawl(userID, 100.0, Currency.GBP);

        withdrawl(userID, 100.0, Currency.GBP);

        withdrawl(userID, 100.0, Currency.GBP);

    }

    private void roundC() {
        logger.info("Round C");

        getBalance(userID);

        deposit(userID, 100.0, Currency.USD);

        deposit(userID, 100.0, Currency.USD);

        withdrawl(userID, 100.0, Currency.USD);

        deposit(userID, 100.0, Currency.USD);

        getBalance(userID);

        withdrawl(userID, 200.0, Currency.USD);

        getBalance(userID);

    }

    private void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
