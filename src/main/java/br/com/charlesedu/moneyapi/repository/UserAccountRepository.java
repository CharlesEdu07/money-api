package br.com.charlesedu.moneyapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.charlesedu.moneyapi.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    public Optional<UserAccount> findByEmail(String email);
}
