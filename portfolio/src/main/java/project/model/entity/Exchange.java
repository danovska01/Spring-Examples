package project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import project.model.entity.enums.ExchangeNameEnum;

@Entity
@Table(name = "exchanges")
public class Exchange extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ExchangeNameEnum exchangeNameEnum;

    public Exchange(){

    }

    public ExchangeNameEnum getExchangeNameEnum() {
        return exchangeNameEnum;
    }

    public void setExchangeNameEnum(ExchangeNameEnum exchangeNameEnum) {
        this.exchangeNameEnum = exchangeNameEnum;
    }
}
