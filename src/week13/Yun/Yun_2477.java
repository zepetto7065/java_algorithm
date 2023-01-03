package week13.Yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Yun_2477 {

    //큰 사각형에서 작은 사각형 빼서 면적을 구해줄 예정

   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numberPer = Integer.parseInt(br.readLine());
        int[] directionArr = new int[12];
        int[] lengthArr = new int[12];
        int small = 0, large = 0, garo = 0, sero = 0;

        //입력
        //입력을 방향배열과 길이배열을 따로 받았는데 방향배열을 보고 동남동남, 북서북서처럼 두 방향이 연속해서 나오는 경우
        // 안쪽에 있는 동'남동'남 에서 남동,  북'서북'서 에서 서북 이 가진 길이가 작은 사각형의 가로, 세로 길이 인것을 파악함.
        // 인덱스 2개씩 비교해주는데 인덱스 범위 신경쓰기 싫어서 배열 두배로 만듦.
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            directionArr[i] = directionArr[i + 6] = direction;
            lengthArr[i] = lengthArr[i + 6] = length;
        }

        //작은 사각형 판단.
        for (int i = 2; i < 6 + 2; i++) {
            if (directionArr[i] == directionArr[i - 2] && directionArr[i + 1] == directionArr[i - 1]) {
                small = lengthArr[i] * lengthArr[i - 1];
            }
        }

        //큰 가로와 큰 세로를 구함. ( 동,서 방향 최댓값이 가로, 남,북 방향 최댓값이 세로)
        for (int i = 0; i < directionArr.length; i++) {
            if (directionArr[i] == 1 || directionArr[i] == 2) {
                garo = Math.max(garo, lengthArr[i]);
            }
            if (directionArr[i] == 3 || directionArr[i] == 4) {
                sero = Math.max(sero, lengthArr[i]);
            }
        }
        large = garo * sero;


        //큰 사각형에서 작은 사각형 빼고 면적 당 갯수를 곱해주고 출력.
        System.out.println((large - small) * numberPer);

    }

}