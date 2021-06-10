package com.revature.WebApp.DTO;

import com.revature.WebApp.entities.MovieUser;
import io.jsonwebtoken.Claims;

public class Principal {

    private int id;
    private String username;
    private MovieUser.Role role;

    public Principal() {
        super();
    }

    public Principal(Claims jwtClaims) {
        this.id = Integer.parseInt(jwtClaims.getId());
        this.username = jwtClaims.getSubject();
        this.role = MovieUser.Role.valueOf(jwtClaims.get("role", String.class).toUpperCase());
    }

    public Principal(MovieUser user) {
        this.id = user.getUserId();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MovieUser.Role getRole() {
        return role;
    }

    public void setRole(MovieUser.Role role) {
        this.role = role;
    }

}