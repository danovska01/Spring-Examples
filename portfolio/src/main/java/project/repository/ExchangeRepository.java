package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Exchange;
@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, String> {
}
