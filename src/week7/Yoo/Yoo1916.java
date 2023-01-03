package week7.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//55908KB 700ms
public class Yoo1916 {
    static int n;
    static int m;

    static ArrayList<Edge>[] adj;
    static int s, e;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, w));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //dijkstra
        int[] ret = dijkstra();
        System.out.println(ret[e]);

    }

    private static int[] dijkstra() {
        //최소값부터 뽑기
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE-1);
        dist[s] = 0;
        pq.add(new Edge(s,0));
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            //현재 가중치가 더 크다면 패스
            if(cur.weight > dist[cur.to]) continue;

            //각 지점의 최소값을 구한다.
            for(Edge eg : adj[cur.to]){
                int nextDistance = eg.weight + cur.weight;
                if(nextDistance < dist[eg.to]){
                    dist[eg.to] = nextDistance;
                    pq.add(new Edge(eg.to, nextDistance));
                }
            }
        }
        return dist;
    }

    private static class Edge{
        int to, weight;

        public Edge(int to , int weight){
            this.to = to;
            this.weight = weight;
        }

    }
}
