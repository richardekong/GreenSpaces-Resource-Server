package com.daveace.greenspaces.account;

import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
public class AccountDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String imageURL;
    private Instant joinedOn;
    private Instant modifiedOn;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public AccountDTO(Account account){
        id = account.getId();
        firstName= account.getFirstName();
        lastName = account.getLastName();
        username = account.getUsername();
        email = account.getEmail();
        imageURL = account.getImageURL();
        joinedOn = account.getJoinOn();
        modifiedOn = account.getModifiedAt();
        isAccountNonLocked = account.isAccountNonLocked();
        isAccountNonExpired = account.isAccountNonExpired();
        isCredentialsNonExpired = account.isCredentialsNonExpired();
        isEnabled = account.isEnabled();
    }


}
