package week6.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11524KB 76ms
public class Yoo9461
{
    static long[] seq = new long[101]; //기하급수적으로 커질것

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //F(n) = F(n-2) + F(n-3)
        fibo();

        for(int i = 0; i < T; i++){
            sb.append(seq[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    private static void fibo() {
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;

        for(int i = 4; i < 101; i++){
            seq[i] = seq[i-2]  + seq[i-3];
        }

    }
}
