package br.com.charlesedu.moneyapi.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.charlesedu.moneyapi.model.UserAccount;
import br.com.charlesedu.moneyapi.repository.UserAccountRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findByEmail(email);

        UserAccount userAccount = userAccountOptional
                .orElseThrow(() -> new UsernameNotFoundException("Email ou senha incorretos"));

        return new User(email, userAccount.getUserAccountPassword(), getPermissions(userAccount));
    }

    private Collection<? extends GrantedAuthority> getPermissions(UserAccount userAccount) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        userAccount.getPermissions()
                .forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getPermissionDescription().toUpperCase())));

        return authorities;
    }
}
