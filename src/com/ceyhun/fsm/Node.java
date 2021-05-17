package com.ceyhun.fsm;

import java.util.HashMap;

public class Node {

    private final String nodeNaam;
    private final HashMap<String, Node> nodeList = new HashMap<>();

    public Node(String nodeNaam) {
        this.nodeNaam = nodeNaam;
    }

    public String getNode() {
        return nodeNaam;
    }

    public HashMap<String, Node> getNodeList() {
        return nodeList;
    }
    public void setNode(Node node, String transitie) {
        nodeList.put(transitie, node);
    }

    public Node Transition(String input){
        return nodeList.getOrDefault(input, null);
    }
}
