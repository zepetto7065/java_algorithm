package week2.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kim_2606 {
    static int computerNum = 0;
    static int connectionNum = 0;
    static boolean[][] map;
    static boolean[] visited;
    static int result;

    //바이러스 : https://www.acmicpc.net/problem/2606  - 76ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerNum = Integer.parseInt(br.readLine());
        connectionNum = Integer.parseInt(br.readLine());
        map = new boolean[computerNum + 1][computerNum + 1];
        visited = new boolean[computerNum + 1];

        int start, end;
        for (int i = 0; i < connectionNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = true;
            map[end][start] = true;
        }

        result = 0;
        countVirus(1);
        System.out.println(result);
    }

    private static void countVirus(int virus) {
        visited[virus] = true;
        for (int i=1;i<=computerNum;i++) {
            if (!visited[i] && map[virus][i]) {
                result+=1;
                countVirus(i);
            }
        }
    }
}
