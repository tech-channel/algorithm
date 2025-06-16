package book.array.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* 몸풀기 문제풀이: 배열 제어하기
* 풀이 권장 시간: 10분
* 권장 시간 복잡도: O(NlogN)
* */
public class ArrayControl {
    public static void main(String[] args) {
        int[] tcRequest1 = {4,2,2,1,3,4};
        int[] tcRequest2 = {2,1,1,3,2,5,4};
        int[] tcResponse1 = {4,3,2,1};
        int[] tcResponse2 = {5,4,3,2,1};

        List<int[]> tcListRequest = List.of(tcRequest1, tcRequest2);
        List<int[]> tcListResponse = List.of(tcResponse1, tcResponse2);

        ArrayControl arraysControl = new ArrayControl();
        for (int i = 0; i < tcListRequest.size(); i++) {
            int[] result = arraysControl.solution(tcListRequest.get(i));
            int[] expected = tcListResponse.get(i);

            System.out.println("result: " + Arrays.toString(result));
            System.out.println("rexpectedesult: " + Arrays.toString(expected));
            System.out.println("응답 결과: " + Arrays.equals(result, expected));
        }
    }

    private int[] solution(int[] nums) {
        int[] result;
        long start = System.nanoTime();

        int[] deleteDuplicates = deleteToDuplicate(nums); // 입력 배열에 중복 값 제거
        result = descToNums(deleteDuplicates); // 중복 제거된 배열 내림차순 정렬

        long end = System.nanoTime();

        System.out.printf("%.7f초\n", (end- start) / 1_000_000_000.0);
        return result;
    }

    private int[] deleteToDuplicate(int[] nums) {
        // 1. nums 배열을 스트림으로 변환
        // 2. 스트림에서 중복된 값 제거
        // 3. 결과를 다시 int[] 배열로 수집
        // 4. 원래 nums 변수에 할당
        nums = Arrays.stream(nums)
                .distinct()
                .toArray();

        return nums;
    }

    private int[] descToNums(int[] nums) {
        // 1) 박싱(int → Integer)
        Integer[] boxed = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        // 2) 내림차순 정렬
        Arrays.sort(boxed, Comparator.reverseOrder());

        // 3) 언박싱(Integer → int)
        /*int boxedLength = boxed.length;
        for (int i = 0; i < boxedLength; i++) {
            nums[i] = boxed[i];
        }*/
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}
