package week12.Park;

public class Park_조이스틱 {

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }


    /**
     * [문제]
     * 맨 처음엔 A로만 이루어져 있습니다.
     * ▲ - 다음 알파벳
     * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
     * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
     * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
     * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값 구하기
     * [제한사항]
     * name은 알파벳 대문자로만 이루어져 있습니다.
     * name의 길이는 1 이상 20 이하입니다.
     **/


    public static int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index;
        int move = length - 1; // 좌우 움직임 수 체크 , i가 0부터니까!

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 이전으로 갈지 다음으로 갈지 결정
            index = i + 1;
            // 연속되는 A 갯수 확인
            while (index < length && name.charAt(index) == 'A') { // 다음 값이 A일경우 실행안함
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);

            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }


}
