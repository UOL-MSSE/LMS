package com.uol.msse.data;

import com.uol.msse.entity.AccountStatus;

import java.util.Date;

/**
 * Data object class to hold Account information of the user
 */
public class Account {

    // USer account number
    private int accountNumber;

    // Date Account is opened
    private Date dateOpened;

    // Account status
    private AccountStatus accountStatus;

    // constructor to poulate the fileds
    public Account(int accountNumber, Date dateOpened, AccountStatus accountStatus) {
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
        this.accountStatus = accountStatus;
    }

    // getters and setters

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
