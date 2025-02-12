package bst;

public class MainBST {
    public static void main(String[] args) {
        NodeBST nodeBST = new NodeBST();
        nodeBST = nodeBST.init();
        System.out.println("==============================");
        System.out.println("BST 모두 보기: " + nodeBST.toString());
        System.out.println("==============================");
    }
}
