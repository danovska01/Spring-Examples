package project.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.service.ExchangeService;
import project.service.TransactionTypeService;

@Component
public class DatabaseInitializer implements CommandLineRunner{


    private final TransactionTypeService transactionTypeService;
    private final ExchangeService exchangeService;

    public DatabaseInitializer(TransactionTypeService transactionTypeService,
                               ExchangeService exchangeService) {
        this.transactionTypeService = transactionTypeService;
        this.exchangeService = exchangeService;
    }



    @Override public void run(String... args) throws Exception {
    transactionTypeService.initTransactionTypes();
    exchangeService.initExchanges();
    }
}

