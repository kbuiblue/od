package com.onlydan.od.security.repositories;

import com.onlydan.od.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> getAccountByAccountName(String accountName);
    Optional<Accounts> getAccountByEmail(String email);
    Boolean checkIfAccountExists(String accountName);
}
