package com.example.springsecurity.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "Security_User_Role")
public class UserRole {
    @EmbeddedId
    @Getter @Setter
    private UserRoleId id;

    @Column(nullable = false)
    @Getter @Setter
    private LocalDate startedAt;
    @Getter @Setter
    private LocalDate endAt;

    @ManyToOne(targetEntity = Role.class)
    @MapsId(value = "roleId")
    @Getter @Setter
    private Role role;

    @ManyToOne(targetEntity = User.class)
    @MapsId(value = "userId")
    @Getter @Setter
    private User user;

    public UserRole() {
        this.id = new UserRoleId();
    }

    public UserRole(User user) {
        this();
//        this.id.userId = user.getId();
        this.user = user;
    }

    public UserRole(User user, Role role) {
        this(user);
//        this.id.roleId = role.getId();
        this.role = role;
    }

    @Embeddable
    @EqualsAndHashCode
    @ToString
    public static class UserRoleId implements Serializable {
        @Getter @Setter
        private Long userId;
        @Getter @Setter
        private Long roleId;
    }

    @PrePersist
    public void persistAction() {
        this.startedAt = LocalDate.now();
    }
}
