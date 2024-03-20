package com.example.SpringEsercizio12.repositories;

import com.example.SpringEsercizio12.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
