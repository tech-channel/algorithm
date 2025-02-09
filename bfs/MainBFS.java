package bfs;

public class MainBFS {
    public static void main(String[] args) {
        // init
        Basic basic = new Basic();
        NodeBFS nodeBFS = new NodeBFS();
        nodeBFS = nodeBFS.init();

        // prepare
        StringBuilder builder = new StringBuilder();
        builder
                .append("==============================")
                .append("\n")
                .append("노드 전체보기: ").append(nodeBFS)
                .append("\n")
                .append("노드 하나보기: ").append(nodeBFS.getData()).append("\t").append(nodeBFS.getChildren())
                .append("\n")
                .append("==============================")
                .append("\n");
        System.out.println(builder);

        // run
        basic.solution(nodeBFS);
    }
}
