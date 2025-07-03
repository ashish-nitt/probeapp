package com.probe.model;

import java.util.random.RandomGenerator;

public class Mesh {
    private NodeState[][] nodes;
    private Probe probe;
    public Mesh(int height, int width, int x, int y, Direction face) {
        this.nodes = new NodeState[height][width];
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        this.probe = new Probe(new Position(randomGenerator.nextInt(width), randomGenerator.nextInt(height)),
                Direction.values()[randomGenerator.nextInt(Direction.values().length)]);
    }

    public Probe getProbe() {
        return probe;
    }

    public NodeState[][] getNodes() {
        return nodes;
    }
}
