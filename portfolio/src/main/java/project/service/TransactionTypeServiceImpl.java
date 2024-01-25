package project.service;

import org.springframework.stereotype.Service;
import project.model.entity.TransactionType;
import project.model.entity.TransactionTypeNameEnum;
import project.repository.TransactionTypeRepository;

import java.util.Arrays;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService{

    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }


    @Override
    public void initTransactionTypes() {
        // Check if transaction types are already initialized
        if (transactionTypeRepository.count() == 0) {
            // If not, initialize transaction types
            Arrays.stream(TransactionTypeNameEnum.values())
                    .forEach(type -> {
                        TransactionType transactionType = new TransactionType();
                        transactionType.setTransactionTypeNameEnum(TransactionTypeNameEnum.valueOf(type.name()));
                        transactionTypeRepository.save(transactionType);
                    });
        }
    }
}
