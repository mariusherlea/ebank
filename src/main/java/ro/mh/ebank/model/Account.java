package ro.mh.ebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_account", unique = true)
    @NotNull(message = "Number account must be between 4 to 15 characters")
    @Size(min = 4, max = 15)
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

    @Column(name = "state")
    private State state;

    public Account() {
    }

}
