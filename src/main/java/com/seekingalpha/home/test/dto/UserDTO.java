package com.seekingalpha.home.test.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
   private int id;
   private String name;
   private String groupName;
   private int numberOfFollowers;
}
