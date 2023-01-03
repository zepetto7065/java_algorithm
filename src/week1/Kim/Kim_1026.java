package week1.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Kim_1026 {
    //1026. 보물 : https://www.acmicpc.net/problem/1026
    public static int problem1026() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] aLine = br.readLine().split(" ");
        String[] bLine = br.readLine().split(" ");
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(aLine[i]));
            B.add(Integer.parseInt(bLine[i]));
        }
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        for(int i=0;i<N;i++){
            result += (A.get(i)*B.get(i));
        }
        System.out.println(result);
        return result;
    }
}
