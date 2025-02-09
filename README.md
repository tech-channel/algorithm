# algorithm
엔지니어들의 알고리즘 학습 내용을 공유합니다.

---
## DFS(깊이 우선 탐색) vs BFS(너비 우선 탐색)
- DFS
  - 자식부터 탐색
  - 관련 자료구조: 스택
  - 장점
    - 재귀 함수 호출로 간단히 구현 가능
    - 보통 BFS 보다 메모리 사용량이 적음
    - 캐시 메모리에 조금 더 친화적
    - 병렬처리에 더 적합
- BFS
  - 이웃부터 탐색
  - 관련 자료구조: 큐
  - 장점
    - 언제나 최소 깊이의 결과를 찾음
    - 깊이가 무한인 트리에도 사용 가능

## Comparison of Stack and Deque Methods

Deques can also be used as LIFO (Last-In-First-Out) stacks.  
This interface should be used in preference to the legacy `Stack` class.  
When a `Deque` is used as a stack, elements are **pushed and popped from the beginning** of the deque.

The equivalent methods are listed in the table below:

| **Stack Method** | **Equivalent Deque Method** | **Description** |
|-----------------|-----------------|-------------------------------|
| `push(e)`      | `addFirst(e)`    | Adds an element to the front |
| `pop()`        | `removeFirst()`  | Removes and returns the front element |
| `peek()`       | `getFirst()`     | Retrieves the front element without removing it |

## Comparison of Queue and Deque Methods

| **Queue Method** | **Equivalent Deque Method** | **Description** |
|------------------|---------------------------|----------------|
| `add(e)`        | `addLast(e)`               | Adds an element at the end |
| `offer(e)`      | `offerLast(e)`             | Adds an element at the end (returns false if full) |
| `remove()`      | `removeFirst()`            | Removes the first element (throws exception if empty) |
| `poll()`        | `pollFirst()`              | Removes the first element (returns null if empty) |
| `element()`     | `getFirst()`               | Retrieves the first element (throws exception if empty) |
| `peek()`        | `peekFirst()`              | Retrieves the first element (returns null if empty) |

---
