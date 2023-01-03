package week13.Park;

import java.util.Scanner;

class Park_2477 {
    /**
     * 참외밭
     * 1m2의 참외 갯수 * 전체 참외밭 넓이를 통해 참외 갯수 구하기
     **/
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int k; // 참외의 갯수
        k = sc.nextInt();
        int[] pos;

        pos = new int[6];

        int len;

        for (int i = 0; i < 6; i++) {
            sc.nextInt(); //길이만 이용해서 값을 구할것이므로 불필요한값
            len = sc.nextInt();

            pos[i] = len; // 길이보관
        }

        int big = 0;
        int small;
        int idx = 0;


        for (int i = 0; i < 6; i++) {  // 두개의 연속 되는 값중 가장 큰값 => 전체 직사각형 넓이
            int tmp = pos[i] * pos[(i + 1) % 6];  // 마지막 값과 처음값 최대일 경우를 대비
            if (big < tmp) { // 값비교
                big = tmp;
                idx = i;
            }
        }

        //반시계방향으로 둘레를 쭉 적어 넣왔으므로 3번째 4번째 인덱스 길이가 제외부분
        small = pos[(idx + 3) % 6] * pos[(idx + 4) % 6];  // 3번째와 4번째 변의 길이 곱하기가 작은 직사각형 넓이

        System.out.println(k * (big - small));

    }
}