package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kim {
    List<Integer> dfsResult = new ArrayList<>();
    List<Integer> bfsResult = new ArrayList<>();
    boolean[] visited;
    boolean[][] map;

    //DFS와 BFS : https://www.acmicpc.net/problem/1260 : 288ms
    public void problem1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        int start, end;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = true;
            map[end][start] = true;
        }

        dfsResult.add(V);
        visited[V]=true;
        dfs(V,N);

        Arrays.fill(visited,false);
        bfsResult.add(V);
        visited[V]=true;
        bfs(V,N);
        for(int i=0;i<N;i++) {
            System.out.print(dfsResult.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<N;i++) {
            System.out.print(bfsResult.get(i)+" ");
        }
    }

    private void dfs(int start, int N) {
        for(int i=1;i<=N;i++){
            if(map[start][i] && !visited[i]) {
                visited[i]=true;
                dfsResult.add(i);
                dfs(i,N);
            }
        }
    }

    private void bfs(int V, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            for(int i=1;i<=N;i++){
                if (map[start][i] && !visited[i]) {
                    visited[i] = true;
                    bfsResult.add(i);
                    queue.add(i);
                }
            }
        }
    }
}
