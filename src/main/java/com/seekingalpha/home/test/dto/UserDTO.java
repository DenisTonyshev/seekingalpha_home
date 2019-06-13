package com.seekingalpha.home.test.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
   private String name;
   private GroupDTO group;
   private int numberOfFollowers;
}
