package com.seekingalpha.home.test.service;

import com.seekingalpha.home.test.dto.*;

import java.util.*;

public interface IDataBaseSQL {

        void addGroups();
    void addUsers();
//Правильнее было бы убрать логирование в отдельный класс и нтерфейс.
    boolean logIn(int id);

    List<UserDTO> getAllUsers();
    List<Integer> getUserFollowersById(int id);
    UserDTO Follow_Unfollow_User(int mainId, int followerId);

}
