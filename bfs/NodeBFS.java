package bfs;

import java.util.ArrayList;
import java.util.List;

public class NodeBFS {
    private String data;
    private List<NodeBFS> children;

    public NodeBFS(String data, List<NodeBFS> children) {
        this.data = data;
        this.children = children;
    }
    public NodeBFS() {}

    public String getData() {
        return data;
    }

    public List<NodeBFS> getChildren() {
        return children;
    }

    public NodeBFS init() {
        // Leaf nodes (J, K, L, G, M, N, I)
        NodeBFS nodeJ = new NodeBFS("J", new ArrayList<>());
        NodeBFS nodeK = new NodeBFS("K", new ArrayList<>());
        NodeBFS nodeL = new NodeBFS("L", new ArrayList<>());
        NodeBFS nodeG = new NodeBFS("G", new ArrayList<>());
        NodeBFS nodeM = new NodeBFS("M", new ArrayList<>());
        NodeBFS nodeN = new NodeBFS("N", new ArrayList<>());
        NodeBFS nodeI = new NodeBFS("I", new ArrayList<>());

        // Intermediate nodes (E, F, H)
        NodeBFS nodeE = new NodeBFS("E", List.of(nodeJ, nodeK));
        NodeBFS nodeF = new NodeBFS("F", List.of(nodeL));
        NodeBFS nodeH = new NodeBFS("H", List.of(nodeM, nodeN));

        // First level nodes (B, C, D)
        NodeBFS nodeB = new NodeBFS("B", List.of(nodeE, nodeF, nodeG));
        NodeBFS nodeC = new NodeBFS("C", List.of(nodeH));
        NodeBFS nodeD = new NodeBFS("D", List.of(nodeI));

        NodeBFS nodeA = new NodeBFS("A", List.of(nodeB, nodeC, nodeD));

        return nodeA;
    }

    @Override
    public String toString() {
        return "NodeBFS{" +
                "data='" + data + '\'' +
                ", children=" + children +
                '}';
    }
}
