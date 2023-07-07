package org.example.repository;

import org.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query("update Customer c set c.login = ?1 where c.id = ?2")
    void updateLoginById(String login, Long id);
    void deleteByLoginIgnoreCase(String login);

    Optional<Customer> findById(Long id);

    Optional<Customer> findCustomerById(Long id);

    Optional<Customer> findByLoginStartsWithIgnoreCase(String symbols);


}
