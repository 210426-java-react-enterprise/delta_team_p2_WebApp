package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "watch_history")
public class WatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @NotNull
    @ManyToOne(targetEntity = MovieUser.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private MovieUser userId;

    @NotNull
    @ManyToOne(targetEntity = Movie.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", nullable = false)
    private Movie movieId;
}
