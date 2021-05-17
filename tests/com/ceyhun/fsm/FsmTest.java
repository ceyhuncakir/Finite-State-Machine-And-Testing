package com.ceyhun.fsm;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FsmTest {

    @Test
    public void run() {
        ArrayList<Node> Nodes = new ArrayList<>();

        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        Fsm fsm = new Fsm(Nodes, s0);

        s0.setNode(s1, "b");
        s0.setNode(s2, "a");
        s1.setNode(s1, "a");
        s1.setNode(s2, "b");
        s2.setNode(s3, "b");
        s3.setNode(s3, "a");
        s3.setNode(s0, "b");

        Nodes.add(s0);
        Nodes.add(s1);
        Nodes.add(s2);
        Nodes.add(s3);

        ArrayList<Node> path = fsm.run("baab");
        assertEquals(5, path.size());
    }

    @Test
    public void nullNodes() {
        ArrayList<Node> Nodes = new ArrayList<>();
        Node s0 = new Node("s0");
        Fsm fsm = new Fsm(Nodes, s0);

        ArrayList<Node> path = fsm.run("baab");
        assertEquals(1, path.size());
    }
}