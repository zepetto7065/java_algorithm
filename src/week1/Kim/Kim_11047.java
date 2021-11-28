package week1.Kim;

import java.util.ArrayList;
import java.util.Scanner;

public class Kim_11047 {
    static int N = 0;
    static int K = 0;
    static int result = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    //11047.동전 0 : https://www.acmicpc.net/problem/11047
    public static int problem11047() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int val = scan.nextInt();
            if (val <= K) {
                arr.add(val);
            }
        }
        dfs(K, 0, arr.size() - 1);
        return result;
    }

    static void dfs(int total, int cnt, int index) {
        if (result > 0 || total < 0) return;
        if (total == 0) {
            result = cnt;
            return;
        }

        if (arr.get(index) < total) {
            dfs(total % arr.get(index), cnt + (total / arr.get(index)), index);
        }
        if (index > 0) {
            dfs(total, cnt, index - 1);
        }
    }
}
