package com.seekingalpha.home.test.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupJPA {
    @Id
    private int id;

    @Column
    private String name;
}
