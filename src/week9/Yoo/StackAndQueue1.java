package week9.Yoo;

import java.util.*;

//기능개발
public class StackAndQueue1 {
    public static void main(String[] args) {
        int[] progresses = new int[]{90, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(solution(progresses, speeds));
    }

    //각 작업 배포일을 구한다.
    //앞에 보다 작은 값의 개수를 구한다
    //10, 3 > 2
    //9 >1
    private static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] day = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            day[i] = (int) (Math.ceil(100 - progresses[i]) / speeds[i]);
        }

        int prev = day[0];
        int count = 1;
        for (int i = 1; i < day.length; i++) {
            if (prev < day[i]) {
                list.add(count);
                count = 1;
                prev = day[i];
            } else {
                count++;
            }
        }
        list.add(count);

        //Array -> Int[] 좋은 방법 없나?
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
