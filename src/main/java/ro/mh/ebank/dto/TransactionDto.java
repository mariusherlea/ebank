package ro.mh.ebank.dto;

public class TransactionDto {


    private Long id;

    private AccountDto debitAccountDto;

    private Double finalAmountSourceAccount;

    private AccountDto creditAccountDto;

    private Double finalAmountTargetAccount;

    private Double transactionAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDto getDebitAccountDto() {
        return debitAccountDto;
    }

    public void setDebitAccountDto(AccountDto debitAccountDto) {
        this.debitAccountDto = debitAccountDto;
    }

    public Double getFinalAmountSourceAccount() {
        return finalAmountSourceAccount;
    }

    public void setFinalAmountSourceAccount(Double finalAmountSourceAccount) {
        this.finalAmountSourceAccount = finalAmountSourceAccount;
    }

    public AccountDto getCreditAccountDto() {
        return creditAccountDto;
    }

    public void setCreditAccountDto(AccountDto creditAccountDto) {
        this.creditAccountDto = creditAccountDto;
    }

    public Double getFinalAmountTargetAccount() {
        return finalAmountTargetAccount;
    }

    public void setFinalAmountTargetAccount(Double finalAmountTargetAccount) {
        this.finalAmountTargetAccount = finalAmountTargetAccount;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
