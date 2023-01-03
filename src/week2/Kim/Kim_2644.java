package week2.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kim_2644 {
    static int N, M, start, end;
    static boolean[][] map;
    static boolean[] visited;
    static int result;
    static int answer;

    //촌수계산 : https://www.acmicpc.net/problem/2644 - 76ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }
        result = 0;
        answer = 0;
        findConnection(start);
        if (answer == 0) answer = -1;
        System.out.println(answer);
    }

    private static void findConnection(int now) {
        if (answer != 0) return;
        if (now == end) {
            answer = result;
            return;
        }
        visited[now] = true;
        result += 1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[now][i]) {
                findConnection(i);
            }
        }
        visited[now] = false;
        result -= 1;
    }
}
