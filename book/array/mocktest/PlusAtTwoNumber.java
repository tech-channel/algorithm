package book.array.mocktest;

import java.util.*;

public class PlusAtTwoNumber {
    public static void main(String[] args) {
        int[] tcRequest1 = {2,1,3,4,1};
        int[] tcRequest2 = {5,0,2,7};
        int[] tcResponse1 = {2,3,4,5,6,7};
        int[] tcResponse2 = {2,5,7,9,12};

        List<int[]> tcListRequest = List.of(tcRequest1, tcRequest2);
        List<int[]> tcListResponse = List.of(tcResponse1, tcResponse2);

        PlusAtTwoNumber plusAtTwoNumber = new PlusAtTwoNumber();
        for (int i = 0; i < tcListRequest.size(); i++) {
            int[] result = plusAtTwoNumber.solution(tcListRequest.get(i));
            int[] expected = tcListResponse.get(i);

            System.out.println("result: " + Arrays.toString(result));
            System.out.println("expected: " + Arrays.toString(expected));
            System.out.println("응답 결과: " + Arrays.equals(result, expected));
        }
    }

    // 시간 복잡도: O(N^2*logN)
    // 	두중 루프 반복 횟수는 \sum_{i=0}^{n-1}(n-i-1) = {n(n-1)}/{2} → O(n²)
    //	만들어지는 합의 개수(m)도 최대 {n(n-1)}/{2} → O(n²)
    //	정렬 복잡도는 O(m log m) = O(n² log n)
    public int[] solution(int[] numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>();
        // 1. 배열에서 두 수를 선택하는 모든 경우의 수를 구한다
        int numberLength = numbers.length;
        for (int i = 0; i < numberLength; i++) {
            for (int j = i+1; j < numberLength; j++) {
                int twoSum = numbers[i] + numbers[j];
                // 2. 과정 1에서 구한 수를 배열에 저장하고 중복을 제거
                nonDuplicateNumbers.add(twoSum);
            }
        }
        
        // 3. 배열을 오름차순으로 정렬 후 반환
        Integer[] sortedNumbers =  nonDuplicateNumbers.stream().sorted().toArray(Integer[]::new);
        int[] results = Arrays.stream(sortedNumbers).mapToInt(Integer::intValue).toArray();

        return results;
    }
}
