package com.soroko.footballleague.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "application_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationUser {

    @Id
    @GeneratedValue
    long id;

    String username;// login | email | phone

    String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    UserRole userRole;

    public ApplicationUser() {
    }

    public ApplicationUser(long id, String username, String password, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    // другие свойства

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
