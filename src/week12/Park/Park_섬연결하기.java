package week12.park;

import java.util.Arrays;

public class Park_구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }


    public static int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;

        Arrays.sort(people);

        // 큰 값 부터 순서대로 진행, 만약 가장 작은 값과 더해도, limit 이하라면, 더해준다.
        for (int i = people.length - 1; i >= 0; i--) {
            if (i < index) {
                break;
            }
            if (limit >= (people[index] + people[i])) {
                index++;
            }
            answer++;
        }
        return answer;
    }
}