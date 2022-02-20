package week13.Yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Yun_17413 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        //잦은 문자열 연산이 발생하기 때문에 StringBuffer 이용.
        //문자열 뒤집기가 필요한 부분을 StringBuffer에 넣어놓고 뒤집어서 출력할 예정.
        StringBuffer sb = new StringBuffer();
        //flag를 통해 여는 괄호(<)와 닫는 괄호(>)안에 있는 문자를 판단할 수 있도록 함.
        int flag = 0;

        //전체 문자열을 돌면서 하나씩 확인
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //'<' 일때는 이제까지 sb에 들어가있던 단어를 뒤집어서 BufferedWriter에 넣어줌.
            // flag는 1로 바꿔 '>'가 올때까지는 그대로 입력하도록 구현함.
            if (ch == '<') {
                bw.write(sb.reverse().toString());
                sb = new StringBuffer();
                flag = 1;
                bw.write('<');
                continue;
            }

            //'>' 일때는 flag를 다시 0으로 바꿔주고 앞으로 들어올 단어들은 차곡차곡 StringBuffer에 넣어줌.
            if (ch == '>') {
                flag = 0;
                bw.write('>');
                continue;
            }

            // flag가 1일 경우니까 그냥 bw에 넣어줌.
            if (flag == 1) {
                bw.write(ch);
                continue;
            }

            // 빈문자열일 경우에 단어하나가 끝난 것이니 이제까지 쌓여있던 sb 뒤집어서 bw에 넣어줌.
            // 괄호 안에 있는 빈문자도 상관없음. sb에 아무것도 안쌓여있으니 빈문자열이 추가돼서 영향 없음.
            if (ch == ' ') {
                bw.write(sb.reverse().toString());
                bw.write(' ');
                sb = new StringBuffer();
                continue;
            }

            // 그 외에는 sb에 차례로 추가해줌.
            sb.append(ch);
        }
        // 다 돌고 sb에 남아있는 값들도 bw에 넣어줌.
        bw.write(sb.reverse().toString());

        //출력
        bw.close();
    }

}
