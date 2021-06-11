package com.revature.WebApp.entities;

import javax.persistence.*;

@Entity
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "settings_id")
    private Integer id;

//    private Integer userId;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private MovieUser user;

    private String theme;
    private Boolean privacy;
}
