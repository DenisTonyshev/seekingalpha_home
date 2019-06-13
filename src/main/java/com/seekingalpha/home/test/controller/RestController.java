package com.seekingalpha.home.test.controller;

import com.seekingalpha.home.test.dto.UserDTO;
import com.seekingalpha.home.test.service.IDataBaseSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

@Autowired
    IDataBaseSQL workWithDB;

    @GetMapping("/")
    List<UserDTO> getAllMembers() {
        return workWithDB.getAllUsers();
    }

    @PostMapping("/")
    UserDTO followUnfollow(@RequestBody int id1,int id2) {
        return workWithDB.Follow_Unfollow_User(id1, id2);
    }

}
