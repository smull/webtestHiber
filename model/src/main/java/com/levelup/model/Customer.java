package com.levelup.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SMULL on 14.02.2015.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BusinessObject {
    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

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
    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToOne(targetEntity = Account.class, mappedBy = "customer")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
