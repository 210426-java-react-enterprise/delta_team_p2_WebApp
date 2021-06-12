package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity representing a row in the watchlist database table which is used to track movies a user
 * has not seen and wants to in the future.
 */
@Entity
@Table(name = "watchlist")
public class WatchlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id")
    private Integer watchlistId;

    @NotNull
    @ManyToOne(targetEntity = UserEntity.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity userId;

    @NotNull
    @ManyToOne(targetEntity = MovieDetailsEntity.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", nullable = false)
    private MovieDetailsEntity movieId;
}
