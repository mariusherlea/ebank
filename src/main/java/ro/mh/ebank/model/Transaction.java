package ro.mh.ebank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;


@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "debit_id")
    @JsonBackReference("debit")
    private Account debitAccount;

    @Column(name = "final_amount_source_account")
    private Double finalAmountSourceAccount;

    @OneToOne
    @JoinColumn(name = "credit_id")
    @JsonBackReference("credit")
    private Account creditAccount;

    @Column(name = "final_amount_target_account")
    private Double finalAmountTargetAccount;

    @Column(name = "transaction_amount")
    private Double transactionAmount;

    public Transaction() {
    }

}
