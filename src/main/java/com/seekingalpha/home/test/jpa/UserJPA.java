package com.seekingalpha.home.test.jpa;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class UserJPA implements Serializable {

    @Id
    private int id;
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "group_id")
    private GroupJPA group;
    @Column(name = "followers")
    private int numberOfFollowers;

    @OneToMany
    @JoinColumn(name = "followers")
    private List<UserJPA> followers;
}
