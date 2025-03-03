package kakao;

import kakao.blind2023.PersonalInformation;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MainKAKAO {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {
                "A 6", "B 12", "C 3"
        };
        String[] privacies = {
                "2021.05.02 A",
                "2021.07.01 B",
                "2022.02.19 C",
                "2022.02.20 C"
        };

        // 시간 포맷 설정 (시:분:초)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // 시작 시간 측정
        LocalTime startTime = LocalTime.now();
        System.out.println("시작 시간: " + startTime.format(formatter));

        // 코딩 테스트 문제 해결 로직 실행
        PersonalInformation personalInformation = new PersonalInformation();
        int[] results = personalInformation.solution_2(today, terms, privacies);
        System.out.println(Arrays.toString(results));

        // 종료 시간 측정
        LocalTime endTime = LocalTime.now();
        System.out.println("종료 시간: " + endTime.format(formatter));

        // Duration을 이용해 시작부터 종료까지의 시간 차이(초 단위) 계산
        long elapsedSeconds = Duration.between(startTime, endTime).getSeconds();
        System.out.println("소요시간: " + elapsedSeconds + "초");

        // 더 정밀한 측정이 필요하면 밀리초 단위로도 계산할 수 있습니다.
        long elapsedMillis = Duration.between(startTime, endTime).toMillis();
        System.out.println("소요시간: " + elapsedMillis + "밀리초");

    }
}
