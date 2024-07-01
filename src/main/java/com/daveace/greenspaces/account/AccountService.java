package com.daveace.greenspaces.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepo repo;

    @Autowired
    public void setRepo(AccountRepo repo) {
        this.repo = repo;
    }


}
