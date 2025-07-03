package com.probe.service;

import com.probe.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public final class ProbeService {
    private final Mesh mesh;

    public ProbeService() {
        this.mesh = new Mesh();
    }

    public Mesh getCurrentMeshState() {
        return mesh;
    }

    public Command sendCommandToProbe(@RequestParam Command command) {
        switch (command) {
            case MOVE: {
                switch (mesh.getProbe().face()) {
                    case UP: {
                        if (mesh.getProbe().position().y() > 0) {
                            Probe probe = mesh.getProbe();
                            mesh.setProbe(new Probe(
                                    new Position(probe.position().x(), probe.position().y() - 1),
                                    probe.face()
                            ));
                        }
                    }
                    case DOWN: {
                        if (mesh.getProbe().position().y() < Mesh.getHeight() - 1) {
                            Probe probe = mesh.getProbe();
                            mesh.setProbe(new Probe(
                                    new Position(probe.position().x(), probe.position().y() + 1),
                                    probe.face()
                            ));
                        }
                    }
                    case LEFT: {
                        if (mesh.getProbe().position().x() > 0) {
                            Probe probe = mesh.getProbe();
                            mesh.setProbe(new Probe(
                                    new Position(probe.position().x() - 1, probe.position().x()),
                                    probe.face()
                            ));
                        }
                    }
                    case RIGHT: {
                        if (mesh.getProbe().position().x() < Mesh.getWidth() - 1) {
                            Probe probe = mesh.getProbe();
                            mesh.setProbe(new Probe(
                                    new Position(probe.position().x() + 1, probe.position().y()),
                                    probe.face()
                            ));
                        }
                    }
                }
            }
            break;
            case ROTATE_RIGHT:
            {
                Direction newDirection = switch (mesh.getProbe().face()) {
                    case UP -> Direction.RIGHT;
                    case RIGHT -> Direction.DOWN;
                    case DOWN -> Direction.LEFT;
                    case LEFT -> Direction.UP;
                };
                Probe probe = mesh.getProbe();
                mesh.setProbe(new Probe(probe.position(), newDirection));
            }
            break;
            case ROTATE_LEFT:
            {
                Direction newDirection = switch (mesh.getProbe().face()) {
                    case UP -> Direction.LEFT;
                    case LEFT -> Direction.DOWN;
                    case DOWN -> Direction.RIGHT;
                    case RIGHT -> Direction.UP;
                };
                Probe probe = mesh.getProbe();
                mesh.setProbe(new Probe(probe.position(), newDirection));
            }
        }
        return command;
}

public Position addHurdle(Position position) {
    if (position.x() < Mesh.getWidth() && position.y() < Mesh.getHeight() &&
            mesh.getNodes()[position.y()][position.x()].equals(NodeState.EMPTY) &&
            !position.equals(mesh.getProbe().position())
    ) {
        mesh.getNodes()[position.y()][position.x()] = NodeState.OCCUPIED;
    } else {
        throw new IllegalArgumentException("Invalid position specified");
    }
    return position;
}
}
