package com.ceyhun.fsm;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void setNode() {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        s0.setNode(s1, "b");
        assertEquals(1, s0.getNodeList().size());
    }

    @Test
    public void transitionExist() {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        s0.setNode(s1, "b");
        s1.setNode(s2, "b");
        assertEquals(s1, s0.Transition("b"));
        assertEquals(s2, s1.Transition("b"));
    }

    @Test
    public void transitionNotExist() {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        s0.setNode(s1, "b");
        assertNull(s0.Transition("a"));
    }
}