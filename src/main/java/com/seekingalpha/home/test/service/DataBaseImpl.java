package com.seekingalpha.home.test.service;

import com.seekingalpha.home.test.dto.*;
import com.seekingalpha.home.test.jpa.*;
import com.seekingalpha.home.test.repo.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class DataBaseImpl implements IDataBaseSQL {

    @Autowired
    SQLGroupRepo groupRepo;
    @Autowired
    SQLUserRepo userRepo;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserJPA> allUsers = userRepo.findAll();
        return UserListJpaToDto(allUsers);
    }

    @Override
    @Transactional
    public UserDTO Follow_Unfollow_User(int mainUser, int follower) {
        UserJPA mainPerson = userRepo.findById(mainUser).orElse(null);
        UserJPA followerPerson = userRepo.findById(follower).orElse(null);
        if (mainPerson != null && followerPerson != null) {
            List<UserJPA> followers = mainPerson.getFollowers();
            if (followers.contains(followerPerson)) {
                followers.remove(followerPerson);
                userRepo.save(mainPerson);
                return UserJpaToDto(mainPerson);
            } else {
                followers.add(followerPerson);
                userRepo.save(mainPerson);
                return UserJpaToDto(mainPerson);
            }
        }
        throw new ObjectNotFoundException(mainPerson, "NO SUCH OBJECT");
    }

    private List<UserDTO> UserListJpaToDto(List<UserJPA> users) {
        List<UserDTO> userDto = new ArrayList<>();
        for (UserJPA user : users) {
            userDto.add(new UserDTO(user.getName(), new GroupDTO(user.getGroup().getName()), user.getFollowers().size()));
        }
        return userDto;
    }

    private UserDTO UserJpaToDto(UserJPA user) {
        return (new UserDTO(user.getName(), new GroupDTO(user.getGroup().getName()), user.getFollowers().size()));
    }
}
