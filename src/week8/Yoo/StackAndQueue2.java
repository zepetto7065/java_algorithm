package week8.Yoo;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;

//프린터
public class StackAndQueue2 {
    public static void main(String[] args) {
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));

    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int now = 0;
        while(!queue.isEmpty()){
            Task cur = queue.poll();
            boolean flag = false;
            for(Task t: queue){
                if(t.priority> cur.priority){
                    flag =true;
                }
            }
            if(flag) { //우선 순위가 높다면 뒤로
                queue.add(cur);
            }else{
                now++;
                if(cur.location == location){
                    answer = now;
                    break;
                }
            }
        }

        return answer;
    }

    static class Task{
        int location;
        int priority;

        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
