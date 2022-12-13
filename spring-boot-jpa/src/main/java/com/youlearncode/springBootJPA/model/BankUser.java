package com.youlearncode.springBootJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "BankUser.cards", attributeNodes = {
        @NamedAttributeNode("cards")
})
public class BankUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String taxId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bank_user_account", joinColumns = @JoinColumn(name = "bank_user_id", foreignKey = @ForeignKey(name = "fk_bank_user_id_account")),
            inverseJoinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_id_bank_user")))
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_user_id", foreignKey = @ForeignKey(name = "fk_bank_user_id_cards"))
    private Set<Card> cards = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankUser)) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(id, bankUser.id) && Objects.equals(name, bankUser.name) && Objects.equals(surname, bankUser.surname) && Objects.equals(taxId, bankUser.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, taxId);
    }
}
