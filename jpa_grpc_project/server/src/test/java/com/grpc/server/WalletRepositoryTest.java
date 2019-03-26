package com.grpc.server;

import com.grpc.Currency;
import com.grpc.server.exception.InsufficientFundsException;
import com.grpc.server.model.WalletEntity;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WalletRepositoryTest {

    @Autowired
    private WalletRepository walletRepository;

    private long userID = 1;

    private static boolean initialized = false;

    @Before
    public void setUp(){
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
    }


    @Test(expected = InsufficientFundsException.class)
    public void testeRepository() throws Exception {
        WalletEntity resultUSD = null ;
        WalletEntity resultEUR = null ;
        WalletEntity resultGPB = null ;

        //1.Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRepository.withdrawalBalanceByUserIdAndCurrency(200.0, userID, Currency.USD.name());


        //2.    Make a deposit of USD 100 to user with id 1.
        walletRepository.depositBalanceByUserIdAndCurrency(100.0, userID, Currency.USD.name());


        //3.    Check that all balances are correct
        resultUSD = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        resultEUR = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.EUR.name());
        resultGPB = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        Assert.assertEquals(resultUSD.getAmount(), 100.0, 0);
        Assert.assertEquals(resultEUR.getAmount(), 0, 0);
        Assert.assertEquals(resultGPB.getAmount(), 0, 0);



        //4.    Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRepository.withdrawalBalanceByUserIdAndCurrency(200.0, userID, Currency.USD.name());



        //5.    Make a deposit of EUR 100 to user with id 1.
        walletRepository.depositBalanceByUserIdAndCurrency(100.0, userID, Currency.EUR.name());


        //6.    Check that all balances are correct
        resultUSD = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        resultEUR = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.EUR.name());
        resultGPB = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        Assert.assertEquals(resultUSD.getAmount(), 100.0, 0);
        Assert.assertEquals(resultEUR.getAmount(), 100.0, 0);
        Assert.assertEquals(resultGPB.getAmount(), 0, 0);



        //7.    Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRepository.withdrawalBalanceByUserIdAndCurrency(200.0, userID, Currency.USD.name());


        //8.    Make a deposit of USD 100 to user with id 1.
        walletRepository.depositBalanceByUserIdAndCurrency(100.0, userID, Currency.USD.name());


        //9.    Check that all balances are correct
        resultUSD = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        resultEUR = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.EUR.name());
        resultGPB = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        Assert.assertEquals(resultUSD.getAmount(), 200.0, 0);
        Assert.assertEquals(resultEUR.getAmount(), 100.0, 0);
        Assert.assertEquals(resultGPB.getAmount(), 0, 0);


        //10. Make a withdrawal of USD 200 for user with id 1. Must return "ok".
        //11. Check that all balances are correct
        walletRepository.withdrawalBalanceByUserIdAndCurrency(200.0, userID, Currency.USD.name());
        resultUSD = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        resultEUR = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.EUR.name());
        resultGPB = walletRepository.findBalanceByUserIdAndCurrency(userID, Currency.USD.name());
        Assert.assertEquals(resultUSD.getAmount(), 0, 0);
        Assert.assertEquals(resultEUR.getAmount(), 100.0, 0);
        Assert.assertEquals(resultGPB.getAmount(), 0, 0);


        //12. Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
        walletRepository.withdrawalBalanceByUserIdAndCurrency(200.0, userID, Currency.USD.name());
    }


}
