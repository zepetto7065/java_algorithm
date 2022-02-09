package week11.Park;

import java.util.Arrays;

public class Park_가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        //int[] -> String[]
        String[] numberArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(numberArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        for (String s : numberArr) answer.append(s);

        // 첫글자가 0일경우 0반환
        return answer.charAt(0) == '0' ? "0" : answer.toString();

        // stream 과 compareTo 사용 하니 1822.11ms 나옴
        // answer StringBuilder 변환시 151.06ms 줄어듬
    }

}