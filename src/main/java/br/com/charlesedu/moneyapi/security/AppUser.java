package br.com.charlesedu.moneyapi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.charlesedu.moneyapi.model.UserAccount;

public class AppUser extends User {
    private static final long serialVersionUID = 1L;

    private UserAccount userAccount;

    public AppUser(UserAccount userAccount, Collection<? extends GrantedAuthority> authorities) {
        super(userAccount.getEmail(), userAccount.getUserAccountPassword(), authorities);

        this.userAccount = userAccount;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
}
