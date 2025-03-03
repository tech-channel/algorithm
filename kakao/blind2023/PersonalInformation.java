package kakao.blind2023;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInformation {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        Map<String, String> convertTerms = new HashMap<>(); // 약관 종류를 key, 약관 유효기간을 value > Map 구현

        for (String term : terms) {
            String[] splited = term.split(" "); // 공백 기준 분리
            convertTerms.put(splited[0], splited[1]); // 약관 정보 HashMap 저장.
            System.out.println(convertTerms);
        }

        int index = 0; // 저장할 인덱스 번호
        int number = 1; // 개인정보 번호
        // privacies 순회
        for (String privacy : privacies) {
            String[] splited = privacy.split(" "); // 공백 기준 분리.
            String searchedTerm = searchTerms(convertTerms, splited[1]); // 날짜의 약관 검색
            String deadLine = createDeadLine(splited[0], searchedTerm); // 약관 데드라인 생성
            if (isTodayToDeadLine(today, deadLine)) { // 오늘 날자와 비교
                System.out.println("index: " + index);
                System.out.println("number: " + number);
                // 약관 유효기간 초과일 경우 결과 저장
                ans.add(number);
            }
            number++;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean isTodayToDeadLine(String today, String deadLine) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        LocalDate deadLineDate = LocalDate.parse(deadLine, formatter);

        System.out.println("today: " + todayDate);
        System.out.println("deadLine: " + deadLineDate);

        return deadLineDate.isBefore(todayDate); // 현재 날짜보다 데드라인 날짜가 이전 날짜라면 True
    }

    private String createDeadLine(String period, String searchedTerm) {
        String[] splitted = period.split("\\."); // '.' 기준 분리
        int month = Integer.parseInt(splitted[1]);
        int searchedMonth = Integer.parseInt(searchedTerm);
        int deadline = month + searchedMonth;


        if (deadline > 12) { // 12월 보다 클 경우, '년' 1 증가 및 월 저장
            splitted[0] = String.valueOf(Integer.parseInt(splitted[0]) + 1);
            int deadLineMonth = deadline - 12;
            splitted[2] = createPrefixDayToZero(createDeadLineToDay(splitted[2]));
            int dayTo28 = verifyDayTo28(splitted[2]);
            splitted[1] = createPrefixToZero(deadLineMonth, dayTo28);
        }
        if (deadline <= 12) { // 12월 보다 작거나 같을 경우, '월' 저장
            splitted[2] = createPrefixDayToZero(createDeadLineToDay(splitted[2]));
            int dayTo28 = verifyDayTo28(splitted[2]);
            splitted[1] = createPrefixToZero(deadline, dayTo28);
        }

        final StringBuilder builder = new StringBuilder();
        builder.append(splitted[0])
                .append(".")
                .append(splitted[1])
                .append(".")
                .append(splitted[2]);

        return builder.toString();
    }

    private int verifyDayTo28(String realDay) {
        if ("28".equals(realDay)) {
            return -1;
        }
        return 0;
    }

    private String createPrefixDayToZero(int deadLineToDay) {
        if (deadLineToDay >= 10) {
            return String.valueOf(deadLineToDay);
        }
        return "0" + deadLineToDay;
    }

    private int createDeadLineToDay(String day) {
        int realDay = Integer.parseInt(day) - 1;
        if (realDay <= 0) {
            return 28;
        }
        return realDay;
    }

    private String createPrefixToZero(int deadLineMonth, int dayTo28) {
        System.out.println("==========");
        System.out.println("Call To createPrefixToZero");
        System.out.println("deadLineMonth: " + deadLineMonth);
        System.out.println("dayTo28: " + dayTo28);
        System.out.println("==========");
        deadLineMonth = deadLineMonth + dayTo28;
        if (deadLineMonth >= 10) {
            return String.valueOf(deadLineMonth);
        }
        return "0" + deadLineMonth;
    }

    private String searchTerms(Map<String, String> convertTerms, String type) {
        return convertTerms.get(type);
    }

    public int[] solution_2(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
