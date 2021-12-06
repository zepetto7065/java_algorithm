package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Yoo {
    private boolean[] check;
    private int[][] map;
    int n;
    int m;
    int v;

    //1260(DFS와 BFS), 2178(미로 탐색), 2606(바이러스), 2667(단지번호붙이기) 2644(촌수계산)
    public void problem1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1; //행렬 제시
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        bfs(v);
    }

    private void dfs(int target) {
        check[target] = true; //방문
        System.out.print(target + " ");
        for (int i = 1; i <= n; i++) {
            if (map[i][target] == 1 && check[i] == false) {
                dfs(i);
            }
        }
    }

    private void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        while (!q.isEmpty()) {
            int pullTarget = q.poll();
            check[pullTarget] = true;
            System.out.print(pullTarget + " ");
            for (int i = 1; i <= n; i++) {
                if (map[i][pullTarget] == 1 && check[i] == false && i != pullTarget) {
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }

    public void problem1() {
        String a = "9999";
        String b = "999";
        String answer = "";

        BigInteger aBig = new BigInteger(a);
        BigInteger bBig = new BigInteger(b);

        BigInteger add = aBig.add(bBig);
        answer = add.toString();

        System.out.println(answer);
    }

    public void problem1_1() {
        String a = "1234";
        String b = "5678";
        String answer = "";

        int max_length = Math.max(a.length(), b.length());
        int[] A = new int[max_length + 1];
        int[] B = new int[max_length + 1];

        for (int i = 0; i < a.length(); i++) {
            A[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            B[i] = b.charAt(b.length() - 1 - i) - '0';
        }

        //더한다
        for (int i = 0; i < max_length; i++) {
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] = A[i + 1] + (value / 10);
        }

        int count = 0;
        if (A[max_length] == 0) {
            count = max_length - 1;
        } else {
            count = max_length;
        }

        for (int i = count; i >= 0; i--) {
            answer += Integer.toString(A[i]);
        }
        System.out.println(answer);
    }

    public void problem2() {
        int[] stats = new int[] { 5, 2, 3, 1, 7, 8, 9, 10 };
        int answer = 0;
        List<List<Integer>> teams = new ArrayList<>();

        for (int i = 0; i < stats.length; i++) {
            boolean isAdd = false;
            //팀이 없을 경우
            if (i == 0) {
                teams.add(new ArrayList<>());
                teams.get(0).add(stats[0]);
                continue;
            }

            //각 팀의 최소값을 체크
            for (int j = 0; j < teams.size(); j++) {
                Integer max = Collections.max(teams.get(j));

                if (max < stats[i]) {
                    //있을 경우
                    teams.get(j).add(stats[i]);
                    isAdd = true;
                    break;
                }
            }

            //없으면 만들어줘
            if (!isAdd) {
                teams.add(new ArrayList<>());
                teams.get(teams.size() - 1).add(stats[i]);
            }

        }
        answer = teams.size();
        System.out.println(answer);
    }
}
