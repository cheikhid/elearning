package com.smart.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart.elearning.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
