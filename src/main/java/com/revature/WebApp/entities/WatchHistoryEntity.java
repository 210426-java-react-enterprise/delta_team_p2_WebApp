package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "watch_history")
public class WatchHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @NotNull
    @ManyToOne(targetEntity = UserEntity.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity userId;

    @NotNull
    @ManyToOne(targetEntity = MovieDetailsEntity.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", nullable = false)
    private MovieDetailsEntity movieId;
}
