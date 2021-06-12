package com.revature.WebApp.entities;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;


import javax.validation.constraints.*;


/**
 * Entity representing a row in database users table, used to store info including auth info for users.
 */
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "username cannot be blank")
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(nullable = false)
    private String password;

    @Email
    //@Pattern(regexp = "^([0-9a-zA-Z.]+@[0-9a-zA-Z]+[.][a-zA-Z]+){1,255}$", message = "need a valid email")
    @Column(nullable = false, unique = true)
    //@NotBlank(message="email can not be blank")
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_bio", nullable = true)
    private String userBio;

    @Column(nullable = false)
    private Role role;
//
//    public UserEntity(/*MovieUser register*/) {
//        super();
//    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MovieUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userBio='" + userBio + '\'' +
                ", role=" + role +
                '}';
    }

    public enum Role {
        ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"),
        PREMIUM_USER("Premium User"), LOCKED("Locked");

        private String name;

        Role(String name) {
            this.name = name;
        }

        @Override
        @JsonValue
        public String toString() {
            return name;
        }
    }

}
