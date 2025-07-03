package com.probe.controller;


import com.probe.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {
    @GetMapping("/mesh")
    Mesh getCurrentMeshState() {
        return new Mesh(0,0,0,0, Direction.RIGHT);
    }

    @PostMapping("/command")
    Command sendCommandToProbe(@RequestParam Command command) {
        return Command.MOVE_RIGHT;
    }

    @PostMapping("/hurdle")
    Position addHurdle(int x, int y) {
        return new Position(0,0);
    }
}
