package com.levelup.model;

import javax.persistence.*;

/**
 * Created by SMULL on 14.02.2015.
 */
@Entity
@Table(name = "BANK")
public class Bank extends  BusinessObject {
    private Long id;

    private String name;

    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
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

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
