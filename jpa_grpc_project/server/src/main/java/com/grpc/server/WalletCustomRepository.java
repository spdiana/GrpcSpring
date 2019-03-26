package com.grpc.server;


import com.grpc.server.exception.InexistentUserIdByCurrencyFoundException;
import com.grpc.server.exception.InsufficientFundsException;
import com.grpc.server.exception.InvalidAmountException;

import javax.transaction.Transactional;

@Transactional
public interface WalletCustomRepository {

    void updateBalanceByUserIdAndCurrency(Double amount, Long userId, String currency);

    void depositBalanceByUserIdAndCurrency(Double amount, Long userId, String currency) throws InvalidAmountException, InexistentUserIdByCurrencyFoundException;

    void withdrawalBalanceByUserIdAndCurrency(Double amount, Long userId, String currency) throws InvalidAmountException, InexistentUserIdByCurrencyFoundException, InsufficientFundsException;


}
