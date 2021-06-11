package com.revature.WebApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "follows_list")
public class FollowsListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Integer friendsListId;

    @NotNull
    @ManyToOne(targetEntity = UserEntity.class, optional = false)
    @JoinColumn(name = "fk_follower_user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity followerUserId;

    @NotNull
    @ManyToOne(targetEntity = UserEntity.class, optional = false)
    @JoinColumn(name = "fk_following_user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity followingUserId;
}
