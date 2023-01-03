package week7.Shin;

import java.util.*;

// 최단 경로: https://www.acmicpc.net/problem/1753 - 2120ms
public class Shin_1753 {

    static int N;
    static int M;
    static List<Bus>[] buses;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N + 1];
        int start = sc.nextInt();

        buses = new ArrayList[N + 1];
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();

            buses[x].add(new Bus(y, cost));
        }

        dijkstra(start);
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();

            if (bus.cost > dist[bus.to]) {
                continue;
            }

            for (Bus nextBus : buses[bus.to]) {
                int nextTo = nextBus.to;
                int newCost = dist[bus.to] + nextBus.cost;

                if (newCost < dist[nextTo]) {
                    dist[nextTo] = newCost;
                    pq.add(new Bus(nextTo, newCost));
                }
            }

        }
    }

    static class Bus implements Comparable<Bus> {
        int to;
        int cost;

        public Bus(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
