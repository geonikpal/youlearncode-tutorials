package com.youlearncode.springBootJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.Objects;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String accountName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToMany(mappedBy = "accounts")
    private Set<BankUser> bankUsers;

    @OneToOne(mappedBy = "account")
    private Card card;

    private String IBAN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Set<BankUser> getBankUsers() {
        return bankUsers;
    }

    public void setBankUsers(Set<BankUser> bankUsers) {
        this.bankUsers = bankUsers;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(accountName, account.accountName) && accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountName, accountType, IBAN);
    }
}