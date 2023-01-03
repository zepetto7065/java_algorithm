package week12.Yoo;

import java.util.Arrays;

public class Yoo_체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        //예외가 하나 있는듯?
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //잃어버린사람이 여벌이 있을 경우, 본인의 여벌 체육복을 착용
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        //사이즈별 체크
        for (int l : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (l == reserve[i] - 1 || l == reserve[i] + 1) {
                    answer += 1;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
