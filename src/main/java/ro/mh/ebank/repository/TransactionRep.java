package ro.mh.ebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebank.model.Transaction;


public interface TransactionRep extends JpaRepository<Transaction, Long> {
}
