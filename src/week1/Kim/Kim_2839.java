package week1.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kim_2839 {
    static int MAX = 5001;
    static int N = 0;
    static int result = MAX;

    //2839. 설탕배달 : https://www.acmicpc.net/problem/2839
    public static int problem2839() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        delivery(0,0,0);
        if (result==MAX) result = -1;
        return result;
    }
    static void delivery(int three, int five, int weight) {
        if (weight > N) return;
        if (result != MAX) return;
        if (weight == N) {
            result = three+five;
            return;
        }
        delivery(three,five+1,weight+5);
        delivery(three+1,five,weight+3);
    }
}
