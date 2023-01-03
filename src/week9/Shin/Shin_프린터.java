package week9.Shin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shin_프린터 {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Item> queue = IntStream.range(0, priorities.length)
                .mapToObj(i -> new Item(priorities[i], i))
                .collect(Collectors.toCollection(LinkedList::new));

        int count = 1;
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            int max = queue.stream().mapToInt(Item::getPriority)
                    .max()
                    .orElse(-1);

            if (item.getPriority() < max) {
                queue.offer(item);
                continue;
            }

            if (item.getLocation() == location) {
                return count;
            }

            count++;
        }

        return count;
    }

    static class Item {
        int priority;
        int location;

        public Item(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return priority;
        }

        public int getLocation() {
            return location;
        }
    }
}
