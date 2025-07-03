package com.probe;

import com.probe.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProbeControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void getCurrentMeshState() {
        Assertions.assertEquals(testRestTemplate.getForObject("/mesh", Mesh.class).getProbe().face(), Direction.RIGHT);
        testRestTemplate.postForObject("/command", Command.ROTATE_RIGHT, Command.class);
        Assertions.assertEquals(testRestTemplate.getForObject("/mesh", Mesh.class).getProbe().face(), Direction.DOWN);
    }

    @Test
    void sendCommandToProbe() {
        Assertions.assertEquals(testRestTemplate.postForObject("/command", Command.ROTATE_RIGHT, Command.class), Command.ROTATE_RIGHT);
    }

    @Test
    void addHurdle() {
        Assertions.assertEquals(testRestTemplate.postForObject("/hurdle", new Position(3,3), Position.class).x(), 3);
    }
}
