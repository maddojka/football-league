package com.soroko.footballleague.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

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
