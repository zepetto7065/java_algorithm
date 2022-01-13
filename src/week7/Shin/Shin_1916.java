package week7.Shin;

import java.util.*;

// 최소 비용 구하기: https://www.acmicpc.net/problem/1916 - 1432ms
public class Shin_1916 {

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
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(fineMinCost(start, end));
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
