package com.example.springsecurity.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "Security_User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String username;
    @Setter
    private String password;

    @OneToMany(targetEntity = UserRole.class, cascade = {CascadeType.PERSIST})
    @Getter @Setter
    private Set<UserRole> userRoles = new HashSet<>();

    @ManyToOne(targetEntity = Groupe.class)
    @Getter @Setter
    private Groupe group;

    public void addRole(Role role) {
        UserRole userRole = new UserRole(this, role);
        this.userRoles.add(userRole);
    }
}
