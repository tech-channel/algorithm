package dfs;

import java.util.ArrayList;
import java.util.List;

public class NodeDFS {
    private String data;
    private List<NodeDFS> children;

    public NodeDFS(String data, List<NodeDFS> children) {
        this.data = data;
        this.children = children;
    }
    public NodeDFS() {}

    public String getData() {
        return data;
    }

    public List<NodeDFS> getChildren() {
        return children;
    }

    // A ~ N 노드 초기화
    public NodeDFS init() {
        // Leaf nodes (G, I, J, K, L, M, N)
        NodeDFS nodeG = new NodeDFS("G", new ArrayList<>());
        NodeDFS nodeI = new NodeDFS("I", new ArrayList<>());
        NodeDFS nodeJ = new NodeDFS("J", new ArrayList<>());
        NodeDFS nodeK = new NodeDFS("K", new ArrayList<>());
        NodeDFS nodeL = new NodeDFS("L", new ArrayList<>());
        NodeDFS nodeM = new NodeDFS("M", new ArrayList<>());
        NodeDFS nodeN = new NodeDFS("N", new ArrayList<>());

        // Intermediate nodes (E, F, H)
        NodeDFS nodeE = new NodeDFS("E", List.of(nodeJ, nodeK));
        NodeDFS nodeF = new NodeDFS("F", List.of(nodeL));
        NodeDFS nodeH = new NodeDFS("H", List.of(nodeM, nodeN));

        // First level nodes (B, C, D)
        NodeDFS nodeB = new NodeDFS("B", List.of(nodeE, nodeF, nodeG));
        NodeDFS nodeC = new NodeDFS("C", List.of(nodeH));
        NodeDFS nodeD = new NodeDFS("D", List.of(nodeI));

        // Root node (A)
        NodeDFS nodeA = new NodeDFS("A", List.of(nodeB, nodeC, nodeD));

        return nodeA;
    }

    @Override
    public String toString() {
        return "NodeDFS{" +
                "data='" + data + '\'' +
                ", children=" + children +
                '}';
    }
}
