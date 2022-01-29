package week10.Shin;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

// 모의고사: https://programmers.co.kr/learn/courses/30/lessons/42840
public class Shin_모의고사 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[] case1 = {1, 2, 3, 4, 5};
        int[] case2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] case3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] total = new int[3];

        AtomicInteger index = new AtomicInteger(0);
        Arrays.stream(answers)
                .forEach(e -> {
                    int i = index.getAndAdd(1);

                    if (answers[i] == case1[i % case1.length]) {
                        total[0]++;
                    }

                    if (answers[i] == case2[i % case2.length]) {
                        total[1]++;
                    }

                    if (answers[i] == case3[i % case3.length]) {
                        total[2]++;
                    }
                });

        int max = Arrays.stream(total)
                .max()
                .getAsInt();

        return IntStream.rangeClosed(1, total.length)
                .filter(i -> total[i - 1] == max)
                .toArray();
    }
}
