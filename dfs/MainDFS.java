package dfs;

public class MainDFS {
    public static void main(String[] args) {
        Basic basic = new Basic();
        NodeDFS node = new NodeDFS();

        node = node.init();
        System.out.println("==============================");
        System.out.println("노드 전체 보기: " + node);
        System.out.println("노드 하나 보기: " + node.getData() + "\n" + node.getChildren());
        System.out.println("==============================");

        // run
        basic.solution(node);
    }
}
