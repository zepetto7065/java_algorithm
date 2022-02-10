package week11;

import java.util.Arrays;

public class Yun_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int arrLength = commands[i][1]-commands[i][0]+1;
            int[] arrExtract = new int[arrLength];

            System.arraycopy(array,commands[i][0]-1,arrExtract,0,arrLength);

            Arrays.sort(arrExtract);

            answer[i] =arrExtract[commands[i][2]-1];
        }
        return answer;
    }
}