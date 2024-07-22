package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user_role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRole {
    @Id
    @GeneratedValue
    int id;

    @Enumerated(EnumType.STRING)
    RoleType roleType;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public enum RoleType {
        ROLE_USER,
        ROLE_MODERATOR,
        ROLE_ADMIN
    }
}
