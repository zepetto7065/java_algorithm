package week9.Shin;

import java.util.*;

// 기능 개발: https://programmers.co.kr/learn/courses/30/lessons/42586
public class Shin_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        for (int i : solution1(progresses, speeds)) {
            System.out.println(i);
        }

        for (int i : solution2(progresses, speeds)) {
            System.out.println(i);
        }
    }

    public static int[] solution1(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!q.isEmpty() && q.peek() < remain) {
                counts.add(q.size());
                q.clear();
            }

            q.offer(remain);
        }

        counts.add(q.size());

        return counts.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int day = 1;

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }

        return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
    }
}
