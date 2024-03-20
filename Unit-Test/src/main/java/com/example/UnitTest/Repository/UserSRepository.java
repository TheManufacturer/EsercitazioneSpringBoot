package com.example.Unittest.Repository;


import com.example.Unittest.Entities.UserS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSRepository extends JpaRepository<UserS, Long> {

}