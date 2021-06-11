package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id")
    private Integer watchlistId;

    @NotNull
    @ManyToOne(targetEntity = MovieUser.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private MovieUser userId;

    @NotNull
    @ManyToOne(targetEntity = Movie.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", nullable = false)
    private Movie movieId;
}
