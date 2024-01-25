package project.service;

import org.springframework.stereotype.Service;
import project.model.entity.Exchange;
import project.model.entity.TransactionType;
import project.model.entity.enums.ExchangeNameEnum;
import project.model.entity.enums.TransactionTypeNameEnum;
import project.repository.ExchangeRepository;

import java.util.Arrays;

@Service
public class ExchangeServiceImpl implements ExchangeService{
    private final ExchangeRepository exchangeRepository;

    public ExchangeServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public void initExchanges() {
        if (exchangeRepository.count() == 0) {
            Arrays.stream(ExchangeNameEnum.values())
                    .forEach(name -> {
                        Exchange exchange= new Exchange();
                        exchange.setExchangeNameEnum(name);
                        exchangeRepository.save(exchange);
                    });
        }
    }
}
