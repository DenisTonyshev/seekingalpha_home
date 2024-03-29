package com.seekingalpha.home.test.service;

import com.seekingalpha.home.test.dto.*;
import com.seekingalpha.home.test.jpa.*;
import com.seekingalpha.home.test.repo.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.*;

@Service
public class DataBaseImpl implements IDataBaseSQL {

    @Autowired
    SQLGroupRepo groupRepo;
    @Autowired
    SQLUserRepo userRepo;

        @Override
    public void addGroups() {
        for (int i = 1; i <= 5; i++) {
            GroupJPA groupJPA = new GroupJPA("GroupName " + i);
            groupRepo.save(groupJPA);
        }
    }
    @Override
    public void addUsers() {
        for (int i = 1; i <= 10; i++) {
            userRepo.save(new UserJPA("IMYA " + i, groupRepo.findById(i % 5 + 1).orElse(null)));
        }
    }

    @Override
    public boolean logIn(int id) {
        if (id < 0) {
            return false;
        }
        UserJPA userJPA = userRepo.findById(id).orElse(null);
        return userJPA != null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserJPA> allUsers = userRepo.getAllUsers();
        return UserListJpaToDto(allUsers);
    }

    @Override
    public  HashSet<Integer> getUserFollowersById(int id) {
       UserJPA byId = userRepo.findById(id).orElse(null);
        return  byId.getFollowers();
    }

    @Override
    @Transactional
    public UserDTO Follow_Unfollow_User(int mainUser, int follower) {
        UserJPA mainPerson = userRepo.findById(mainUser).orElse(null);
        UserJPA followerPerson = userRepo.findById(follower).orElse(null);
        if (mainUser == follower || mainUser <= 0 || follower <= 0) {
            return UserJpaToDto(mainPerson);
        }
        if (mainPerson != null && followerPerson != null) {
            HashSet<Integer> followers = mainPerson.getFollowers();
            if (followers.contains(followerPerson.getId())) {
                followers.remove(followerPerson.getId());
                mainPerson.setNumberOfFollowers(followers.size());
                mainPerson.setFollowers(followers);
                userRepo.save(mainPerson);
                return UserJpaToDto(mainPerson);
            } else {
                followers.add(followerPerson.getId());
                mainPerson.setNumberOfFollowers(followers.size());
                mainPerson.setFollowers(followers);
                userRepo.save(mainPerson);
                return UserJpaToDto(mainPerson);
            }
        }
        throw new ObjectNotFoundException(mainPerson, "Not Found");
    }

    private List<UserDTO> UserListJpaToDto(List<UserJPA> users) {
        List<UserDTO> userDto = new ArrayList<>();
        for (UserJPA user : users) {
            userDto.add(new UserDTO(user.getId(), user.getName(), new GroupDTO(user.getGroup_id().getName()).getName(), user.getNumberOfFollowers()));
        }
        return userDto;
    }

    private UserDTO UserJpaToDto(UserJPA user) {
        return (new UserDTO(user.getId(), user.getName(), new GroupDTO(user.getGroup_id().getName()).getName(), user.getNumberOfFollowers()));
    }
}
