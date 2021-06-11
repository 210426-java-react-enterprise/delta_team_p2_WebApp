package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @NotNull
    @Column(name = "imdb_id", nullable = false)
    private String imdbId;

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String poster;

    //TODO: add other attributes/fields
}
