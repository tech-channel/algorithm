package linked_list;

/* 텍스트 다이어그램으로 보는 동작 과정.
* mergeTwoLists(1→3→5, 2→4→6)
      │
      └─ 비교: 1 vs 2 → 1 선택
            │
            └─ 1.next = mergeTwoLists(3→5, 2→4→6)
                         │
                         └─ 비교: 3 vs 2 → 2 선택
                               │
                               └─ 2.next = mergeTwoLists(3→5, 4→6)
                                          │
                                          └─ 비교: 3 vs 4 → 3 선택
                                                │
                                                └─ 3.next = mergeTwoLists(5, 4→6)
                                                           │
                                                           └─ 비교: 5 vs 4 → 4 선택
                                                                 │
                                                                 └─ 4.next = mergeTwoLists(5, 6)
                                                                            │
                                                                            └─ 비교: 5 vs 6 → 5 선택
                                                                                  │
                                                                                  └─ 5.next = mergeTwoLists(null, 6)
                                                                                            │
                                                                                            └─ 기저 조건: list1 == null → 반환 6
*
* */

public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            System.out.println("call to if");
            System.out.println("list1.val: " + list1.val);
            System.out.println("list2.val: " + list2.val);
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            System.out.println("call to else");
            System.out.println("list1.val: " + list1.val);
            System.out.println("list2.val: " + list2.val);
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
