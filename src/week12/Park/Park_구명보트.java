package week12.Park;

import java.util.Arrays;

public class Park_구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    /**
     * [문제]
     * 구명보트가 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
     * [제한사항]
     * 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
     * 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
     * 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
     * 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
     **/

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int index = people.length-1;


        Arrays.sort(people); // int 배열이라 Integer 로변경해야지만 내림차순 가능

        for (int i=0 ; i < index ; index--) {
            // 남은 인원에 가장 큰값 + 작은값이 제한숫자 이내인지 확인
            if (limit >= (people[i] + people[index])) {
                i++;
                answer++;
            }
        }

        return people.length - answer;
    }
}