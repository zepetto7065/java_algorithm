package week12.Park;

import java.util.Arrays;

public class Park_체육복 {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
    }

    /**
     * [문제]
     * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
     * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다
     * [제한사항]
     * 전체 학생의 수는 2명 이상 30명 이하입니다.
     * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
     * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
     * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
     * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
     * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
     * [요약]
     * 참여 가능한 인원에서 뒷번호나 앞번호에 있을경우 체육복 빌려줌
     * 빌려준 경우 값을 변경하여 더이상 못빌려주게 함
     **/

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;  // 참여가능 학생수

        Arrays.sort(lost); // 조건에 순서대로 입력된다는 말이 없으므로 정렬 필요
        Arrays.sort(reserve);

        // 위에 반복문과 밑에 반복문을 같이 사용하고 싶었는데 같이 할경우 테스트 12번이 계속 실패함
        // 여벌 학생복 있는 학생이 도난 당한경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 그외 도난 당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }


}
