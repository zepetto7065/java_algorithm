package week6.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kim_10942 {
    //펠린드롬? : https://www.acmicpc.net/problem/10942 - 시간초과
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line[i-1]);
        }
        int M = Integer.parseInt(br.readLine());
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result[i]=isPelindrom(start,end)? 1 : 0;
        }
        for(int i=0;i<M;i++) {
            System.out.println(result[i]);
        }
    }

    private static boolean isPelindrom(int start, int end) {
        while (start <= end) {
            if (arr[start]!=arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
