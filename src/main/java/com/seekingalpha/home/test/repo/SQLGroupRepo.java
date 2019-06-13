package com.seekingalpha.home.test.repo;

import com.seekingalpha.home.test.jpa.GroupJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLGroupRepo extends JpaRepository<GroupJPA,Integer> {
}
