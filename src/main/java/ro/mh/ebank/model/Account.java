package ro.mh.ebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account extends AuditModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private Long accountNumber;

    private String bank;

    private Double amount;

    private String state;

    public Account() {
    }

    public Account(User user, Long accountNumber, String bank, Double amount, String state) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.amount = amount;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) &&
                user.equals(account.user) &&
                accountNumber.equals(account.accountNumber) &&
                bank.equals(account.bank) &&
                amount.equals(account.amount) &&
                state.equals(account.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, accountNumber, bank, amount, state);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user=" + user +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", amount=" + amount +
                ", state='" + state + '\'' +
                '}';
    }
}
