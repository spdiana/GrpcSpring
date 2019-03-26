package com.grpc.server.model;

import com.grpc.BalanceRequest;
import com.grpc.Currency;
import com.grpc.WalletRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class WalletEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String currency;

    private double amount;

    public WalletEntity() {

    }

    public WalletEntity(Long userId, String currency, double amount) {
        this.userId = userId;
        this.currency = currency;
        this.amount = amount;
    }

    public WalletRequest toProto() {
        return WalletRequest.newBuilder()
                .setUserId(getUserId())
                .setCurrency(getEnumCurrency())
                .setAmount(getAmount())
                .build();
    }


    public static WalletEntity fromProto(WalletRequest proto) {
        WalletEntity entry = new WalletEntity();
        entry.setUserId(proto.getUserId());
        entry.setCurrency(proto.getCurrency().toString());
        entry.setAmount(proto.getAmount());
        return entry;
    }

    public static WalletEntity fromProto(BalanceRequest proto) {
        WalletEntity entry = new WalletEntity();
        entry.setUserId(proto.getUserId());
        return entry;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public Currency getEnumCurrency() {
        Currency cur = Currency.UNRECOGNIZED;
        if(getCurrency().equals(Currency.EUR.name())) {
            cur = Currency.EUR;
        } else if(getCurrency().equals(Currency.USD.name())){
            cur = Currency.USD;
        } else if(getCurrency().equals(Currency.GBP.name())){
            cur = Currency.GBP;
        }
        return cur;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity entity = (WalletEntity) o;
        return Double.compare(entity.amount, amount) == 0 &&
                id.equals(entity.id) &&
                userId.equals(entity.userId) &&
                currency.equals(entity.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, currency, amount);
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
