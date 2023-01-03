package week11.Yoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yoo_K번째수 {
    static int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};

    public static void main(String[] args) {
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] solution = solution(commands);
        for (int num : solution) {
            System.out.println(num);
        }
    }

    private static int[] solution(int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            //array 자르기
            int[] slicedArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);

            //array 정렬하기
            Arrays.sort(slicedArray);

            //k번째 수 확인
            result.add(slicedArray[command[2]-1]);
        }

        return result.stream().mapToInt(Integer::intValue)
                .toArray();
    }
}
