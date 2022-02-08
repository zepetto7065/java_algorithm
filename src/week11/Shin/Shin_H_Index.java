package week11.Shin;

import java.util.Arrays;
import java.util.stream.IntStream;

// H-Index: https://programmers.co.kr/learn/courses/30/lessons/42747
public class Shin_H_Index {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) {
        int max = Arrays.stream(citations)
                .max()
                .getAsInt();

        return IntStream.iterate(max, i -> i > 0, i -> i - 1)
                .filter(i -> getCount(citations, i) >= i)
                .findFirst()
                .orElse(0);

    }

    private static int getCount(int[] citations, int value) {
        return (int) Arrays.stream(citations)
                .filter(c -> c >= value)
                .count();
    }
}
