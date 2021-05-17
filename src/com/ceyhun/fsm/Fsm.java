package com.ceyhun.fsm;

import java.util.ArrayList;

public class Fsm {

    private final ArrayList<Node> nodes;
    private final ArrayList<Node> nodePath = new ArrayList<>();
    private final Node startNode;

    public Fsm(ArrayList<Node> nodes, Node startNode){
        this.nodes = nodes;
        this.startNode = startNode;
    }

    public ArrayList<Node> run(String input){
        nodePath.add(startNode);
        Node last_Node = startNode;

        System.out.printf("We starten op node : %s%n", startNode.getNode());

        for (char input_char : input.toCharArray()) {
            Node node = last_Node.Transition(String.valueOf(input_char));

            if (node == null){
                System.out.print("Er is geen transitie gevonden");
                break;
            } else {
                System.out.print("\n" + last_Node.getNode() + " gaat met de transitie (" + input_char + ") naar " + node.getNode() + "\n");
                nodePath.add(node);
            }
            last_Node = node;
        }
        System.out.printf("\nde transitie eindigt op Node: %s", last_Node.getNode());
        return nodePath;
    }

    public String toString(){
        StringBuilder str = new StringBuilder("Nodes ");
        for (Node n : nodes) {
            str.append("\n").append(n.getNode());
        }
        return str.toString();
    }
}
