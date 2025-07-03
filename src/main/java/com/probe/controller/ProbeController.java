package com.probe.controller;


import com.probe.model.*;
import com.probe.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProbeController {
    @Autowired
    ProbeService probeService;

    @GetMapping("/mesh")
    Mesh getCurrentMeshState() {
        return probeService.getCurrentMeshState();
    }

    @PostMapping("/command")
    Command sendCommandToProbe(@RequestBody Command command) {
        return probeService.sendCommandToProbe(command);
    }

    @PostMapping("/hurdle")
    Position addHurdle(@RequestBody Position position) {
        return probeService.addHurdle(position);
    }
}
