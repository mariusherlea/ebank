package ro.mh.ebank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transfer")
public class Transfer extends AuditModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "debit_id")
    @JsonBackReference("debit")
    private Account debitAccount;

    @OneToOne
    @JoinColumn(name = "credit_id")
    @JsonBackReference("credit")
    private Account creditAccount;

    private Double tranferAmount;

    public Transfer() {
    }


}
