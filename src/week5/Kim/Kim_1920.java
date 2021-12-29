package week5.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kim_1920 {
    //수찾기 : https://www.acmicpc.net/problem/1920 - 63792kb	1648ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] find = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        for (int i = 0; i < M; i++) {
            int val = find[i];
            int start = 0;
            int end = N - 1;
            int middle = (start + end) / 2;
            boolean isFin = false;

            while (start <= end) {
                middle = (start + end) / 2;
                if (map[middle] == val) {
                    isFin = true;
                    break;
                }
                else if (val > map[middle]) {
                    start = middle + 1;
                }else{
                    end = middle - 1;
                }
            }
            System.out.println(isFin? 1 : 0);
        }
    }
}
