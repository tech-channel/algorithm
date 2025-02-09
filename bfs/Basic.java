package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Basic {
    // 최단 경로 찾기에 권장됨.
    public void solution(NodeBFS node) {
        Deque<NodeBFS> queue = new ArrayDeque<>();
        queue.addLast(node);
        System.out.println("지금 추가한 큐: " + queue);

        while (!queue.isEmpty()) {
            // queue 동작방식 FIFO 사용
            NodeBFS next = queue.removeFirst();
            System.out.println("removeFirst 값: " + next.getData());

            for (NodeBFS child : next.getChildren()) {
                queue.addLast(child);
                System.out.println("현재 노드의 자식 노드 추가한 큐: " + child);
            }
        }

        /* OUTPUT: BFS 방문 순서 (동일한 깊이 먼저 파기)
        * A - B - C - D - E - F - G - H - I - J - K - L - M - N
        * */
    }
}
