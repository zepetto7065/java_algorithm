package week1.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Kim_11399 {
    static int N = 0;
    static int result = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    //11399. ATM : https://www.acmicpc.net/problem/11399
    public static int problem11399() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        Collections.sort(arr);
        int waitTime = 0;
        for (int index = 0; index < arr.size(); index++) {
            waitTime = (waitTime + arr.get(index));
            result += waitTime;
        }
        return result;
    }
}
