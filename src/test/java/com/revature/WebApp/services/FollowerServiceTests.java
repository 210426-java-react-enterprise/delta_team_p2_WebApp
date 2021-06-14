package com.revature.WebApp.services;

import com.revature.WebApp.DTO.FollowerDetailDTO;
import com.revature.WebApp.entities.FollowsListEntity;
import com.revature.WebApp.entities.UserEntity;
import com.revature.WebApp.repositories.FollowsDetailRepository;
import com.revature.WebApp.repositories.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FollowerServiceTests {

    FollowerService sut;
    UserRepository mockUserRepo;
    FollowsDetailRepository mockFollowRepo;
    FollowsListEntity mockFollow;

    @Before
    public void setUp() {
        mockUserRepo = mock(UserRepository.class);
        mockFollowRepo = mock(FollowsDetailRepository.class);
        mockFollow = mock(FollowsListEntity.class);
        sut = new FollowerService(mockFollowRepo,mockUserRepo);
    }

    @After
    public void tearDown() {
        mockUserRepo = null;
        mockFollowRepo = null;
        mockFollow = null;
        sut = null;
    }

    @Test
    public void testFindAllFollowers() {
        ArrayList<FollowsListEntity> arrayList = new ArrayList<>();

        //Arrange
        when(mockFollowRepo.findAll()).thenReturn(new ArrayList<FollowsListEntity>(5));

        //Act
        arrayList = (ArrayList<FollowsListEntity>) sut.findAllFollowers();

        //Assert
        Assert.assertNotNull(arrayList);
    }

    @Test
    public void getAllFollowerDetail() {
        //Arrange
        ArrayList mockArray = mock(ArrayList.class);
        ArrayList arrayList = new ArrayList<>();
        when(mockFollowRepo.findAll()).thenReturn(new ArrayList<>(5));

        //Act
        arrayList = (ArrayList<FollowerDetailDTO>)sut.getAllFollowerDetail("5");
        //Assert
        System.out.println(arrayList);
        Assert.assertNotNull(arrayList);
    }
}
