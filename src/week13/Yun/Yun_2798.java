package week13.Yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yun_2798 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    static int[] arr;
    static int max = 0, N, M;

    public static void main(String[] args) throws IOException {
        //입력받아줌.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //재귀함수 돌림
        powerSet(0, 0, 0);
        //재귀함수 다 돌고 최종 max값 출력
        System.out.println(max);
    }

    //재귀함수에는 매개변수가 idx, sum, cnt가 있는데
    //재귀함수를 돌면서 cnt가 3이 될때 sum값을 판단해서 상한값인 max보다 낮으면 원래 있던 max값과 비교해서 더 큰 값으로 갱신함.
    public static void powerSet(int idx, int sum, int cnt) {
        //기본조건
        if (cnt == 3) {
            if (sum <= M) {
                max = Math.max(max, sum);
            }
            return;
        }
        //idx가 범위를 넘어가면 종료함.
        if (idx == arr.length) {
            return;
        }

        //현재 idx에 있는 값을 포함하지 않고 진행
        powerSet(idx + 1, sum, cnt);
        //현재 idx에 있는 값을 포함하고 진행
        powerSet(idx + 1, sum + arr[idx], ++cnt);

    }

}