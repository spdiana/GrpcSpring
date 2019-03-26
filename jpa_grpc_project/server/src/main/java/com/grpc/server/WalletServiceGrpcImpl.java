package com.grpc.server;


import com.grpc.*;
import com.grpc.server.exception.InexistentUserIdByCurrencyFoundException;
import com.grpc.server.exception.InsufficientFundsException;
import com.grpc.server.exception.InvalidAmountException;
import com.grpc.server.exception.UnknownCurrencyException;
import com.grpc.server.model.WalletEntity;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Currency;


@GRpcService
public class WalletServiceGrpcImpl extends WalletServiceGrpc.WalletServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(WalletServiceGrpcImpl.class);

    @Autowired
    private WalletRepository repository;

    @Override
    public void balance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {

        List<WalletEntity> listEntity = repository.findBalanceByUserId(request.getUserId());

        if (listEntity.isEmpty()) {
            String msg = "Wallet balance not founded - User ID: " + request.getUserId();
            logger.info(msg);
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription(msg)
                    .withCause(new EntityNotFoundException(msg))
                    .asRuntimeException());
            return;
        }

        Map<String, Double> resultMap = listEntity.stream().collect(
                Collectors.toMap(WalletEntity::getCurrency, WalletEntity::getAmount));

        BalanceResponse response = BalanceResponse.newBuilder()
                .putAllBalanceByCurrency(resultMap)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void deposit(WalletRequest request, StreamObserver<WalletResponse> responseObserver) {

        try {
            checkCurrency(request.getCurrency().name());
        } catch (UnknownCurrencyException ex) {
            logger.error(ex.getMessage(), ex);

            responseObserver.onError(Status.UNKNOWN
                    .withDescription(ex.getMessage())
                    .augmentDescription("Unknown currency")
                    .withCause(ex)
                    .asRuntimeException());
            return;
        }

        try{
            repository.depositBalanceByUserIdAndCurrency(request.getAmount(), request.getUserId(), request.getCurrency().name());
        } catch (InvalidAmountException | InexistentUserIdByCurrencyFoundException ex) {

            logger.error(ex.getMessage(), ex);
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription(ex.getMessage())
                    .withCause(new EntityNotFoundException(ex.getMessage()))
                    .asRuntimeException());
            return;
        }

        responseObserver.onNext(WalletResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void withdrawal(WalletRequest request, StreamObserver<WalletResponse> responseObserver) {

        try {
            checkCurrency(request.getCurrency().name());
        } catch (UnknownCurrencyException ex) {
            logger.error(ex.getMessage(), ex);

            responseObserver.onError(Status.UNKNOWN
                    .withDescription(ex.getMessage())
                    .augmentDescription("Unknown currency")
                    .withCause(ex)
                    .asRuntimeException());
            return;
        }

        try{
            repository.withdrawalBalanceByUserIdAndCurrency(request.getAmount(), request.getUserId(), request.getCurrency().name());
        } catch (InvalidAmountException | InexistentUserIdByCurrencyFoundException | InsufficientFundsException ex) {
            logger.error(ex.getMessage(), ex);
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription(ex.getMessage())
                    .withCause(new EntityNotFoundException(ex.getMessage()))
                    .asRuntimeException());
            return;
        }

        responseObserver.onNext(WalletResponse.getDefaultInstance());
        responseObserver.onCompleted();

    }


    @Override
    public void all(AllWallet request, StreamObserver<WalletRequest> responseObserver) {
        repository.findAll().forEach(e -> {
            responseObserver.onNext(e.toProto());
        });
        responseObserver.onCompleted();
    }


    private  void checkCurrency(String currencyCode) throws UnknownCurrencyException {
        try {
            Currency.getInstance(currencyCode);
        } catch (Exception e) {
            throw new UnknownCurrencyException("Unknown currency: " + currencyCode);
        }
    }

}
