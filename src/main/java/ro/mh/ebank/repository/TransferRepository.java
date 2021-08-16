package ro.mh.ebank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ro.mh.ebank.model.Transfer;
import ro.mh.ebank.model.User;


public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
