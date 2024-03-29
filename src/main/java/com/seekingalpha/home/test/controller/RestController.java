package com.seekingalpha.home.test.controller;

import com.seekingalpha.home.test.dto.FollowerDTO;
import com.seekingalpha.home.test.dto.UserDTO;
import com.seekingalpha.home.test.jpa.UserJPA;
import com.seekingalpha.home.test.service.IDataBaseSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:63342")
public class RestController {

    @Autowired
    IDataBaseSQL workWithDB;

        @GetMapping("/auto")
    void addToDBTest() {
        workWithDB.addGroups();
        System.out.println("Groups Created");
        workWithDB.addUsers();
        System.out.println("Users Created");
    }
    @GetMapping("/")
    List<UserDTO> getAllMembers() {
        return workWithDB.getAllUsers();
    }

    @GetMapping("/login")
    boolean logIn(@RequestParam(name = "id") int id){
        return workWithDB.logIn(id);
    }

    @GetMapping(value = "/{id}")
    HashSet<Integer> followers(@PathVariable(name = "id") int id){
        return workWithDB.getUserFollowersById(id);
    }


    @PostMapping("/")
    UserDTO followUnfollow(@RequestBody FollowerDTO followerDTO) {
        return workWithDB.Follow_Unfollow_User(followerDTO.getId1(), followerDTO.getId2());
    }

}
