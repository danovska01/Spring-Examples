package project.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction extends BaseEntity{

    private String coinName;
    private LocalDateTime date;
    @ManyToOne
    private TransactionType transactionType;
    @OneToOne
    private Exchange exchange;

    private BigDecimal price;
    private double amount;

    private BigDecimal totalUSDT;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    public Transaction(){

    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double quantity) {
        this.amount = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalUSDT() {
        return totalUSDT;
    }

    public void setTotalUSDT(BigDecimal totalUSDT) {
        this.totalUSDT = price.multiply(BigDecimal.valueOf(amount));
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
