package com.example.couponSpring.repos;

import com.example.couponSpring.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    boolean existsByIdAndName(int id, String name);

    boolean existsById(int id);

    Optional<Company> findByEmail(String email);

}
