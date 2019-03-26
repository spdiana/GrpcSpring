package com.grpc.server;

import com.grpc.server.exception.InexistentUserIdByCurrencyFoundException;
import com.grpc.server.exception.InsufficientFundsException;
import com.grpc.server.exception.InvalidAmountException;
import com.grpc.server.model.WalletEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Service
public class WalletCustomRepositoryImpl implements WalletCustomRepository {

    private static final Logger logger = LoggerFactory.getLogger(WalletCustomRepositoryImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    WalletRepository walletRepository;


    @Override
    public void updateBalanceByUserIdAndCurrency(Double amount, Long userId, String currency) {

        String sql = "UPDATE WalletEntity w SET w.amount = :amount WHERE w.userId = :userId AND w.currency = :currency";
        Query query = entityManager.createQuery(sql);
        query.setParameter("amount", amount);
        query.setParameter("userId", userId);
        query.setParameter("currency", currency);
        query.executeUpdate();
        entityManager.clear();
        entityManager.flush();
    }


    @Override
    public void depositBalanceByUserIdAndCurrency(Double amount, Long userId, String currency) throws InvalidAmountException, InexistentUserIdByCurrencyFoundException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount Exception - User ID: " + userId);
        }

        WalletEntity entity = findWalletEntityByUserIdAndCurrency(userId, currency);

        double newAmount = entity.getAmount() + amount;
        updateBalanceByUserIdAndCurrency(newAmount, userId, currency);
    }

    @Override
    public void withdrawalBalanceByUserIdAndCurrency(Double amount, Long userId, String currency) throws InvalidAmountException, InexistentUserIdByCurrencyFoundException, InsufficientFundsException {


        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount Exception - User ID: " + userId);
        }

        WalletEntity entity = findWalletEntityByUserIdAndCurrency(userId, currency);

        //Verify If the User ID has Funds to Withdraw
        if (entity.getAmount() >= amount) {
            double newAmount = entity.getAmount() - amount;
            updateBalanceByUserIdAndCurrency(newAmount, userId, currency);
        } else {
            throw new InsufficientFundsException("Funds Not enough to Withdraw - User ID: " + userId);
        }


    }

    private WalletEntity findWalletEntityByUserIdAndCurrency(Long userId, String currency) throws InexistentUserIdByCurrencyFoundException {

        //Verify if the User Exists in the database
        WalletEntity entity = walletRepository.findBalanceByUserIdAndCurrency(userId, currency);

        if (entity == null) {
            throw new InexistentUserIdByCurrencyFoundException("User ID not found: " + userId);
        }
        return entity;
    }
}
