package week12.park;

import java.util.Arrays;

public class Park_체육복 {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 위에 반복문과 밑에 반복문을 같이 사용하고 싶었는데 같이 할경우 테스트 12번이 계속 실패함
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }


        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }


}
