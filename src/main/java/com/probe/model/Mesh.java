package com.probe.model;

import java.util.random.RandomGenerator;

public class Mesh {
    private NodeState[][] nodes;
    private Probe probe;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 10;
    public Mesh() {
        this.nodes = new NodeState[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                nodes[i][j] = NodeState.EMPTY;
            }
        }
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        System.out.println(" " + WIDTH +  " " + HEIGHT);
        this.probe = new Probe(new Position(randomGenerator.nextInt(WIDTH), randomGenerator.nextInt(HEIGHT)), Direction.RIGHT);
    }

    public Probe getProbe() {
        return probe;
    }

    public NodeState[][] getNodes() {
        return nodes;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public void setProbe(Probe probe) {
        this.probe = probe;
    }
}
