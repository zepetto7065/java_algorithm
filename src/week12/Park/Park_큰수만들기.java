package week12.Park;

public class Park_큰수만들기 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }

    /**
     * [문제]
     * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
     * [제한사항]
     * number 는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
     * k는 1 이상 number 의 자릿수 미만인 자연수입니다.
     **/

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < number.length() - k; i++) {
            char maxNum = '0';
            for (int j = index; j <= k + i; j++) {

                // 현재값보다 큰값이 있는지 비교후 가장 큰값을 더해줌
                if (maxNum < number.charAt(j)) {
                    maxNum = number.charAt(j);
                    index = j + 1; // 다음 자리수로 이동
                }
            }
            answer.append(maxNum);
        }
        return answer.toString();
    }


}
