package com.sr.searchroom.repository;

import com.sr.searchroom.SearchRoomApplicationTests;
import com.sr.searchroom.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserJpaRespositoeyTest extends SearchRoomApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetInfo() {

        User user = userRepository.findOne(1l);
        Assert.assertEquals("wali", user.getName());
    }
}