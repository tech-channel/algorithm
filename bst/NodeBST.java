package bst;

public class NodeBST {
    public int data;
    public NodeBST left;
    public NodeBST right;

    public NodeBST(int data, NodeBST left, NodeBST right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public NodeBST() {}

    public NodeBST init() {
        // Leaf node (1, 3, 5, 7, 9, 12)
        NodeBST node1 = new NodeBST(1, null, null);
        NodeBST node3 = new NodeBST(3, null, null);
        NodeBST node5 = new NodeBST(5, null, null);
        NodeBST node7 = new NodeBST(7, null, null);
        NodeBST node9 = new NodeBST(9, null, null);
        NodeBST node12 = new NodeBST(12, null, null);

        // Intermediate node (2, 8, 15)
        NodeBST node2 = new NodeBST(2, node1, node3);
        NodeBST node8 = new NodeBST(8, node7, node9);
        NodeBST node15 = new NodeBST(15, node12, null);

        // First Level node (4, 10)
        NodeBST node4 = new NodeBST(4, node2, node5);
        NodeBST node10 = new NodeBST(10, node8, node15);

        // Root node (6)
        NodeBST node6 = new NodeBST(6, node4, node10);

        return node6;
    }

    @Override
    public String toString() {
        return "NodeBST{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
