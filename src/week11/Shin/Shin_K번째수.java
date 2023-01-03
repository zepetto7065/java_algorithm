package week11.Shin;

import java.util.Arrays;
import java.util.stream.IntStream;

// K번째수: https://programmers.co.kr/learn/courses/30/lessons/42748
public class Shin_K번째수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        return IntStream.range(0, commands.length)
                .map(i -> getResult(array, commands[i]))
                .toArray();
    }

    private static int getResult(int[] array, int[] command) {
        int[] newArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
        Arrays.sort(newArray);
        return newArray[command[2] - 1];
    }
}
