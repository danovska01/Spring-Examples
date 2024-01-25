package project.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.service.TransactionTypeService;

@Component
public class DatabaseInitializer implements CommandLineRunner{


    private final TransactionTypeService transactionTypeService;

    public DatabaseInitializer(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }



    @Override public void run(String... args) throws Exception {
    transactionTypeService.initTransactionTypes();
    }
}

