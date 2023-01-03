package week11.Shin;

import java.util.Arrays;
import java.util.stream.Collectors;

// 가장 큰 수: https://programmers.co.kr/learn/courses/30/lessons/42746
public class Shin_가장큰수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }

    public static String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((e1, e2) -> (e2 + e1).compareTo(e1 + e2))
                .collect(Collectors.joining());

        if (result.startsWith("0")) {
            return "0";
        }

        return result;
    }
}
