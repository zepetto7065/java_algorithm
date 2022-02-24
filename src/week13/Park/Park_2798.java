package week13.Park;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Park_2798 {
    /**
     * 블랙잭
     * 완전탐색문제
     * 조건1. 카드합 <= 21
     * 조건2. N장의 카드중 3장 뽑기 => 합이 M 이하이면서 근처 값
     **/
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt(); // 합

        int[] arr = new int[N];

        int result = 0;
        int temp;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        // 카드 3개의 값만 필요하므로 -2 부터 시작
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    temp = arr[i] + arr[j] + arr[k];

                    if (temp <= M) {  // M 보다 작은값 중 최대므로
                        result = Math.max(temp, result);
                    }
                }
            }
        }

        System.out.println(result);
    }
}