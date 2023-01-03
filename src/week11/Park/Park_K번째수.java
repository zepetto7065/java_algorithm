package week11.Park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Park_K번째수 {

    public int[] solution(int[] array, int[][] commands) {

        // array를 통해 배열 값을 받은후  , 2차원배열 commands 받기
        int[] answer =  new int[commands.length];

        // 배열 => 몇번째부터 몇번째까지
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // 자르고 난후

            Arrays.sort(tmp); // 정렬 하고

            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}