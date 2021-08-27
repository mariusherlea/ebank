package ro.mh.ebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /*@Column(name = "number_account", unique = true)
    @NotNull(message = "Number account must be between 4 to 15 characters")
    @Size(min = 4, max = 15)*/
    private Long accountNumber;

    @Column(name = "bank")
    private String bank;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @Column(name = "amount")
    private Double amount;

   /* @Column(name = "state")
    private State state;*/

    public Account() {
    }

    public Account(Long accountNumber, String bank, User user, Double amount) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.user = user;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(bank, account.bank) &&
                Objects.equals(user, account.user) &&
                Objects.equals(amount, account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, bank, user, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }
}
