package book.array.basic;

import java.util.Arrays;
import java.util.List;

/* 몸풀기 문제: 배열 정렬하기
* 풀이 권장 시간: 10분
* 권장 시간 복잡도: O(NlogN)
* */
public class ArraySort {
    public static void main(String[] args) {
        int[] numsTcRequest1 = {1,-5,2,4,3};
        int[] numsTcRequest2 = {2,1,1,3,2,5,4};
        int[] numsTcRequest3 = {6,1,7};
        int[] numsTcRequest4 = new int[100000];
        int[] numsTcResponse1 = {-5,1,2,3,4};
        int[] numsTcResponse2 = {1,1,2,2,3,4,5};
        int[] numsTcResponse3 = {1,6,7};
        int[] numsTcResponse4 = new int[100000];

        List<int[]> tcListRequest = List.of(numsTcRequest1, numsTcRequest2, numsTcRequest3, numsTcRequest4);
        List<int[]> tcListResponse = List.of(numsTcResponse1, numsTcResponse2, numsTcResponse3, numsTcResponse4);

        ArraySort arraySort = new ArraySort();
        for (int i = 0; i < tcListRequest.size(); i++) {
            int[] result = arraySort.solution(tcListRequest.get(i));
            int[] expected = tcListResponse.get(i);

            //System.out.println("result: " + Arrays.toString(result));
            //System.out.println("expected: " + Arrays.toString(expected));
            System.out.println("응답 결과: " + Arrays.equals(result, expected));
        }
    }

    private int[] solution(int[] nums) {
        int[] result;
        long start = System.nanoTime();
        //result = bubbleSort(nums);
        result = doSort(nums);
        long end = System.nanoTime();

        System.out.printf("%.7f초\n", (end- start) / 1_000_000_000.0);
        return result;
    }

    private int[] doSort(int[] origin) {
        int[] clone = origin.clone();
        Arrays.sort(clone);

        return clone;
    }

    private int[] bubbleSort(int[] origin) {
        int[] clone = origin.clone();
        int numsLength = clone.length - 1;
        for (int i = 0; i < numsLength; i++) {
            for (int j = 0; j < numsLength - i; j++) {
                if (clone[j] > clone[j + 1]) {
                    int temp = clone[j];
                    clone[j] = clone[j + 1];
                    clone[j + 1] = temp;
                }
            }
        }

        return clone;
    }
}
