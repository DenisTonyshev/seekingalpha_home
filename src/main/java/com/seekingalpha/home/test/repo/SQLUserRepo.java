package com.seekingalpha.home.test.repo;

import com.seekingalpha.home.test.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLUserRepo extends JpaRepository<UserJPA,Integer> {

}
