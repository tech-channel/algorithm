package dfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Basic {
    public void solution(NodeDFS node) {
        // Java API 명세에 이제는 Stack 대신 Deque 인터페이스 구현체를 사용하라고 권장
        Deque<NodeDFS> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // stack 동작방식 LIFO 사용
            NodeDFS next = queue.pollLast();
            System.out.println("pollLast 값: " + next.getData());

            for (NodeDFS child : next.getChildren()) {
                System.out.println("현재 child 값: " + child.getData());
                queue.add(child);
            }
        }


        /* OUTPUT: DFS 방문 순서 (한 우물 파기)
         * A - D - I - C - H - N - M - B - G - F - L - E - K - J
         * */
    }
}
