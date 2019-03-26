package com.grpc.server;


import com.grpc.server.model.WalletEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface WalletRepository extends PagingAndSortingRepository<WalletEntity, Long>, WalletCustomRepository {


    @Query("FROM WalletEntity w WHERE w.userId = :id")
    List<WalletEntity> findBalanceByUserId(@Param("id")Long userId);

    @Query("FROM WalletEntity w WHERE w.userId = :userId and w.currency = :currency")
    WalletEntity findBalanceByUserIdAndCurrency(@Param("userId")Long userId, @Param("currency")String currency);


    //Added to JUnit Test
    @Modifying(clearAutomatically=true, flushAutomatically = true)
    @Query(value = "truncate table wallet_entity", nativeQuery = true)
    void truncateTable();
}
