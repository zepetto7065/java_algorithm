package week13.Park;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Park_17413 {
    /**
     * 단어 뒤집기 2
     * 조건1. <>안의 값은 변경 X
     * 조건2. 단어 구분은 공백
     * 조건3. 단어별 뒤집기
     * **/

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder(); // 단어 구분

        for (int i = 0; i < name.length(); i++) {

            word.append(name.charAt(i));

            if (word.indexOf(">") > -1) { //> 값을 만나기전까지 계속 더해줌
                sb.append(word);
                word.delete(0, word.length());

            } else if (word.indexOf("<") == 0) {
                continue;

            } else if ((name.charAt(i) == ' ') || word.toString().endsWith("<")) { // 공백이나 < 만난경우
                word.delete(word.length() - 1, word.length());
                word.reverse();
                sb.append(word);// 기존단어 추가
                word.delete(0, word.length());

                if (name.charAt(i) == ' ') {
                    sb.append(name.charAt(i));
                } else {
                    word.append(name.charAt(i));
                }
            }
        }

        word.reverse();
        sb.append(word);

        System.out.println(sb);

    }
}