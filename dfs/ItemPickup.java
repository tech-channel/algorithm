package dfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class ItemPickup {
    /* TODO
     *   캐릭터 위치 큐 저장
     *   큐가 비어있을 때 까지 반복
     *   현재 좌표 아이템 발견시 step 반환
     *   조건1. 테두리 범위가 벗어나면 패스
     *   조건2. 이미 방문한 경우 패스
     *   조건3. 이동 불가능한 테두리 패스
     *   현재 좌표 방문처리
     *   현재 좌표 큐 저장
     *   조건1과 조건3은 > 이동 가능한 테두리를 구할 수 있는 경우 통합 가능.
     * */

    /* NOTE 문제 해결 오류를 잡는 디버깅 수행해보자...
        배율(x2)을 적용하고 보드를 구성하는 데 오류 발견....
        좌표 배열 전체를 1로 채우면 안됨
        직사각형 외부도 이동 가능한 경로로 인식되어 캐릭터가 의도치 않은 경로를 탐색 함
        테두리 경로만 1로 채우는 로직으로 수정이 필요함...*/
    public static class Move {
        private int currentX;
        private int currentY;
        private int step;

        public Move(int currentX, int currentY, int step) {
            this.currentX = currentX;
            this.currentY = currentY;
            this.step = step;
        }
    }

    public static class Mask {
        private int bottomX;
        private int bottomY;
        private int topX;
        private int topY;

        public Mask(int bottomX, int bottomY, int topX, int topY) {
            this.bottomX = bottomX;
            this.bottomY = bottomY;
            this.topX = topX;
            this.topY = topY;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 101x101 크기의 보드 배열 생성
        int arraySize = 101;
        int[][] board = new int[arraySize][arraySize];

        // 2. 원래 좌표를 2배로 확대 후 테두리 '1' 마스킹
        for (int[] rect : rectangle) {
            rect[0] *= 2;
            rect[1] *= 2;
            rect[2] *= 2;
            rect[3] *= 2;
            maskingToCellLine(board, new Mask(rect[0], rect[1], rect[2], rect[3]));
        }
        // 2-1. 시작, 목표 좌표도 2배 확대된 좌표 사용
        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;

        // 3. 각 직사각형 내부(테두리를 제외한 영역)를 '0' 마스킹 (즉, 테두리만 1로 남김)
        for (int[] rect : rectangle) {
            int bottomX = rect[0] + 1;
            int bottomY = rect[1] + 1;
            int topX = rect[2] - 1;
            int topY = rect[3] - 1;
            maskingToCellInternal(board, new Mask(bottomX, bottomY, topX, topY));
        }

        // 4. BFS 탐색 준비
        boolean[][] visited = new boolean[arraySize][arraySize];
        Deque<Move> queue = new ArrayDeque<>();
        queue.addLast(new Move(startX, startY, 0));
        visited[startY][startX] = true;

        // 4-1. 이동 방향: 오른쪽, 왼쪽, 아래, 위
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 4-2. 실제 탐색
        while (!queue.isEmpty()) {
            Move move = queue.pollFirst();
            // 목표 좌표 도달 시, 실제 이동 거리는 좌표 확대한 만큼 더 이동하기 때문에 현재 step 2로 나눈 값 return
            if (move.currentX == targetX && move.currentY == targetY) return move.step / 2;
            for (int i = 0; i < 4; i++) {
                int nx = move.currentX + dx[i]; // 이동한 x 좌표
                int ny = move.currentY + dy[i]; // 이동한 y 좌표
                // 범위 체크
                if (nx >= 0 && ny >= 0 && nx < 101 && ny < 101) {
                    // 아직 방문하지 않았고, 해당 셀이 테두리(1)라면 이동 가능
                    if (!visited[ny][nx] && board[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.addLast(new Move(nx, ny, move.step + 1));
                    }
                }
            }
        }
        // 문제 조건 상 항상 경로가 존재하므로 여기까지 오지 않음
        return 0;
    }

    private void maskingToCellLine(int[][] board, Mask mask) {
        // 테두리 마스킹: 테두리를 '1' 처리
        for (int i = mask.bottomY; i <= mask.topY; i++) {
            for (int j = mask.bottomX; j <= mask.topX; j++) {
                board[i][j] = 1; // (x,y) -> (열, 행) 접근: board[y][x]
            }
        }
    }

    private void maskingToCellInternal(int[][] board, Mask mask) {
        // 내부 셀(테두리 제외) 마스킹: 내부를 '0' 처리
        for (int i = mask.bottomY; i <= mask.topY; i++) {
            for (int j = mask.bottomX; j <= mask.topX; j++) {
                board[i][j] = 0; // (x,y) -> (열, 행) 접근: board[y][x]
            }
        }
    }

    public static void main(String[] args) {
        ItemPickup ip = new ItemPickup();
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1, characterY = 3;
        int itemX = 7, itemY = 8;
        int result = ip.solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println("최단 이동 거리 : " + result); // 17
    }
}
