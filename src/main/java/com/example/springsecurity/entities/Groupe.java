package com.example.springsecurity.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
@ToString
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToMany(targetEntity = Role.class)
    private List<Role> roles;
}
