package week7.Shin;

import java.util.*;

// 특정한 최단 경로: https://www.acmicpc.net/problem/1504 - 1528ms
public class Shin_1504 {

    static int N;
    static int M;
    static List<Bus>[] buses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        buses = new ArrayList[N + 1];
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();

            buses[x].add(new Bus(y, cost));
            buses[y].add(new Bus(x, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        long result1 = fineMinCost(1, start);
        result1 += fineMinCost(start, end);
        result1 += fineMinCost(end, N);

        long result2 = fineMinCost(1, end);
        result2 += fineMinCost(end, start);
        result2 += fineMinCost(start, N);

        long minCost = Math.min(result1, result2);
        if (minCost >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
        }
    }

    private static int fineMinCost(int start, int end) {
        int[] dist = new int[N + 1];
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

        return dist[end];
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
