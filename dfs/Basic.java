package dfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Basic {
    public void solution(NodeDFS node) {
        // Java API 명세에 이제는 Stack 대신 Deque 인터페이스 구현체를 사용하라고 권장
        Deque<NodeDFS> stack = new ArrayDeque<>();
        stack.addFirst(node);
        System.out.println("지금 추가한 스택: " + stack);

        while (!stack.isEmpty()) {
            // stack 동작방식 LIFO 사용
            NodeDFS next = stack.removeFirst();
            System.out.println("removeFirst 값: " + next.getData());

            for (NodeDFS child : next.getChildren()) {
                stack.addFirst(child);
                System.out.println("현재 노드의 자식 노드 추가한 스택: " + child);
            }
        }

        /* OUTPUT: DFS 방문 순서 (한 우물 파기)
         * A - D - I - C - H - N - M - B - G - F - L - E - K - J
         * */
    }
}
