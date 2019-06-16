package com.seekingalpha.home.test.jpa;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class UserJPA implements Serializable {

    public UserJPA(String name, GroupJPA group) {
        this.name = name;
        this.group_id = group;
        this.numberOfFollowers = 0;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupJPA group_id;

    @Column(name = "NumberOfFollowers")
    private int numberOfFollowers;

    @OneToMany
    @JoinColumn(name = "followers")
    private List<UserJPA> followers;

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name +
                ", group_id=" + group_id +
                ", numberOfFollowers=" + numberOfFollowers;
    }
}
