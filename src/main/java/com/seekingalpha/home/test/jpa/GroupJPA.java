package com.seekingalpha.home.test.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "groups")
public class GroupJPA {

    public GroupJPA(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name;
    }
}
