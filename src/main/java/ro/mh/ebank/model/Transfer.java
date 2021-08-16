package ro.mh.ebank.model;

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
    @JoinColumn(name = "account_id")
    private Account debitAccount;

    /*@OneToOne
    @JoinColumn(name = "account_id")
    private Account creditAccount;*/

    private Double tranferAmount;

    public Transfer() {
    }

    public Transfer(Account debitAccount, Account creditAccount, Double tranferAmount) {
        this.debitAccount = debitAccount;
//        this.creditAccount = creditAccount;
        this.tranferAmount = tranferAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(Account debitAccount) {
        this.debitAccount = debitAccount;
    }

  /*  public Account getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Account creditAccount) {
        this.creditAccount = creditAccount;
    }*/

    public Double getTranferAmount() {
        return tranferAmount;
    }

    public void setTranferAmount(Double tranferAmount) {
        this.tranferAmount = tranferAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return id.equals(transfer.id) &&
                debitAccount.equals(transfer.debitAccount) &&
//                creditAccount.equals(transfer.creditAccount) &&
                tranferAmount.equals(transfer.tranferAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debitAccount,  tranferAmount);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", debitAccount=" + debitAccount +
//                ", creditAccount=" + creditAccount +
                ", tranferAmount=" + tranferAmount +
                '}';
    }
}
