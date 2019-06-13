package com.seekingalpha.home.test.service;

import com.seekingalpha.home.test.dto.*;
import com.seekingalpha.home.test.jpa.UserJPA;

import java.util.*;

public interface IDataBaseSQL {

   List<UserDTO> getAllUsers();
   UserDTO Follow_Unfollow_User(int mainId, int followerId);

}
