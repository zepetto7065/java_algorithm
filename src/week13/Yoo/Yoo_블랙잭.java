package week13.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoo_블랙잭 {
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search());
    }

    private static int search() {
        int result = 0;

        for (int i = 0; i < n - 2; i++) { //3개를 골라야하므로 n-2

            if (array[i] > m) continue; // 첫번째 카드가 m보다 크다면 skip

            for (int j = i + 1; j < n - 1; j++) {

                if (array[j] + array[i] > m) continue;

                for (int k = j + 1; k < n; k++) {
                    if (m == array[i] + array[j] + array[k]) return m;

                    if (result < array[i] + array[j] + array[k] && array[i] + array[j] + array[k] < m) {
                        result = array[i] + array[j] + array[k];
                    }
                }
            }

        }

        return result;
    }
}
