package week12.Park;

import java.util.Arrays;
import java.util.Comparator;

public class Park_단속카메라 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    /**
     * [문제]
     * 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때,
     * 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지
     * [제한사항]
     * 차량의 대수는 1대 이상 10,000대 이하입니다.
     * routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점,
     * routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
     * 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
     * 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.

     => 요약
     차량 진입 진출 시점 카메라 설치 되어있어야 함
     routes 를 정렬해서 비교
     routes[0] ~[1] 사이에 카메라 한대를 설치하고 [1]보다 큰경우 발생시 한대 더설치 => 반복
     **/

    public static int solution(int[][] routes) {
        int answer = 0;

        int min = -30000; // 진출지점중 젤 작은값으로

        Arrays.sort(routes, Comparator.comparingInt((o) -> o[1])); // 작은값부터 큰값으로 정렬

        for (int[] route : routes) {
            if (route[0] > min) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }
}
