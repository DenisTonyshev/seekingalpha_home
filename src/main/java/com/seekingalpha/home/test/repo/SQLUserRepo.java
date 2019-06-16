package com.seekingalpha.home.test.repo;

import com.seekingalpha.home.test.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SQLUserRepo extends JpaRepository<UserJPA,Integer> {
 @Query(
         value = "SELECT * FROM users",
         nativeQuery = true)
 List<UserJPA> getAllUsers();
}
