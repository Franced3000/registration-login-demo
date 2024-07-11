package org.example.registrationlogindemo.repository;

import org.example.registrationlogindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}