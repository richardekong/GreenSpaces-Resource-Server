package com.daveace.greenspaces.account;


import com.daveace.greenspaces.util.Constant;
import com.daveace.greenspaces.util.Regexp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Objects;

import static com.daveace.greenspaces.util.Constant.INVALID_IMAGE_URL;
import static com.daveace.greenspaces.util.Constant.INVALID_NAME;
import static com.daveace.greenspaces.util.Regexp.ALPHA_NUM_REGEX;
import static com.daveace.greenspaces.util.Regexp.LETTER_REGEX;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name="accounts")
public class Account {

    @Id
    private String id;

    @Pattern(regexp = LETTER_REGEX, message = INVALID_NAME)
    private String firstName;

    @Pattern(regexp = LETTER_REGEX, message = INVALID_NAME)
    private String lastName;

    @Pattern(regexp = ALPHA_NUM_REGEX, message = "Username must contain alphanumeric characters")
    private String username;

    @Email(message = "Invalid email")
    private String email;

    @Pattern(regexp = Regexp.IMAGE_URL_REGEX, message = INVALID_IMAGE_URL)
    private String imageURL;
    private final Instant joinOn = Instant.now();
    private Instant modifiedAt;


    @Column(name="account_non_expired")
    private boolean isAccountNonExpired;

    @Column(name="account_non_locked")
    private boolean isAccountNonLocked;

    @Column(name="credentials_non_expired")
    private boolean isCredentialsNonExpired;

    @Column(name="account_enabled")
    private boolean isEnabled;


    @PrePersist
    public void onSave(){
        isAccountNonExpired=true;
        isAccountNonLocked=true;
        isCredentialsNonExpired=true;
        isEnabled=true;
    }

    @PreUpdate
    public void onUpdate(){
        modifiedAt = Instant.now();
    }

    public AccountDTO toDTO(){
        return new AccountDTO(this);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", joinOn=" + joinOn +
                ", modifiedAt=" + modifiedAt +
                ", email='" + email + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isAccountNonExpired == account.isAccountNonExpired
                && isAccountNonLocked == account.isAccountNonLocked
                && isCredentialsNonExpired == account.isCredentialsNonExpired
                && isEnabled == account.isEnabled
                && Objects.equals(id, account.id)
                && Objects.equals(firstName, account.firstName)
                && Objects.equals(lastName, account.lastName)
                && Objects.equals(username, account.username)
                && Objects.equals(imageURL, account.imageURL)
                && Objects.equals(joinOn, account.joinOn)
                && Objects.equals(modifiedAt, account.modifiedAt)
                && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, imageURL, joinOn, modifiedAt, email,
                isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled);
    }
}
