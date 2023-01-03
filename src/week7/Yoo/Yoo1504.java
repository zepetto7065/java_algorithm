package week7.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Yoo1504{
    static List<Point> list[];
    static int dist[];
    static boolean check[];
    static int n, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        check = new boolean[n + 1];

        //간선 초기화
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Point(end, weight));
            list[end].add(new Point(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int req1 = Integer.parseInt(st.nextToken());
        int req2 = Integer.parseInt(st.nextToken());

        int answer = solve(req1, req2);
        System.out.println(answer);
    }

    private static int solve(int req1, int req2) {
        int result1 = 0;
        int result2 = 0;

        //경로 1
        //1-> 필수 1 최단
        result1 += dijkstra(1, req1);
        //필수1 -> 필수 2 최단
        result1 += dijkstra(req1, req2);
        //필수2 -> n 최단
        result1 += dijkstra(req2, n);

        //경로 2
        //1-> 필수 2 최단
        result2 += dijkstra(1, req2);
        //필수2 -> 필수 1 최단
        result2 += dijkstra(req2, req1);
        //필수1 -> n 최단
        result2 += dijkstra(req1, n);

        if (result1 >= Integer.MAX_VALUE - 1 && result2 >= Integer.MAX_VALUE - 1) return -1;
        else return Math.min(result1, result2);
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE - 1);
        Arrays.fill(check, false);

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if (check[curNode]) continue;
            check[curNode] = true;

            for (int i = 0; i < list[curNode].size(); i++) {
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;

                //미방문 + 기존 거리보다 새로운 거리가 작을 경우
                if (check[nextNode] == false && dist[nextNode] > curWeight + nextWeight) {
                    dist[nextNode] = curWeight + nextWeight;
                    queue.add(new Point(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }

}

class Point implements Comparable<Point> {
    int end;
    int weight;

    public Point(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
        return weight - o.weight;
    }
}