package week2.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kim_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int house;

    //단지번호붙이기 : https://www.acmicpc.net/problem/2667 - 92ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int result = 0;
        List<Integer> houseCount = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result += 1;
                    house = 0;
                    makeNumber(i, j);
                    houseCount.add(house);
                }
            }
        }
        Collections.sort(houseCount);

        System.out.println(result);
        for (Integer integer : houseCount) {
            System.out.println(integer);
        }
    }

    private static void makeNumber(int x, int y) {
        visited[x][y] = true;
        house += 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                makeNumber(nx, ny);
            }
        }
    }
}
