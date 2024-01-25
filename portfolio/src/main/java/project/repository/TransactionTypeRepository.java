package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.TransactionType;


@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, String> {
}
