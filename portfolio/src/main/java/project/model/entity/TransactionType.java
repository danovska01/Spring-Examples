package project.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_type")
public class TransactionType extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private TransactionTypeNameEnum transactionTypeNameEnum;

    public TransactionType(){

    }

    public TransactionTypeNameEnum getTransactionTypeNameEnum() {
        return transactionTypeNameEnum;
    }

    public void setTransactionTypeNameEnum(TransactionTypeNameEnum transactionTypeNameEnum) {
        this.transactionTypeNameEnum = transactionTypeNameEnum;
    }
}
