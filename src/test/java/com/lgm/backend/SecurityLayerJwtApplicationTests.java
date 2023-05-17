package com.lgm.backend;

import com.lgm.backend.model.backendDb.Point;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.PointRepository;
import com.lgm.backend.repository.backendDb.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SecurityLayerJwtApplicationTests {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {

        Point point = new Point();

        Optional<User> user = userRepository.findByEmail("admin@gmail.com");

        point.setUser(user.get());

        pointRepository.save(point);



    }

}