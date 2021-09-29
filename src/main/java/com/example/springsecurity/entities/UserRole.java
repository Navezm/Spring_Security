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
    private UserRoleId id;

    @Column(nullable = false)
    @Getter @Setter
    private LocalDate startedAt;
    @Getter @Setter
    private LocalDate endAt;

    @ManyToOne(targetEntity = Role.class)
    @MapsId(value = "roleId")
    private Role role;

    @ManyToOne(targetEntity = User.class)
    @MapsId(value = "userId")
    private User user;

    @Embeddable
    @EqualsAndHashCode
    @ToString
    public static class UserRoleId implements Serializable {
        @Getter @Setter
        private Long userId;
        @Getter @Setter
        private Long roleId;
    }
}
