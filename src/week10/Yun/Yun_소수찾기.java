package week10.Yun;

import java.util.HashSet;
import java.util.Set;

public class Yun_소수찾기 {
    public Set<Integer> set = new HashSet<>();
    public String[] stringArr;
    public boolean[] visited;
    public int ans = 0;

    public int solution(String numbers) {
        stringArr = numbers.split("");
        visited = new boolean[stringArr.length];

        appendNumber(0, "");

        for (Integer integer : set) {
            if (isPrimeNumber(integer)) {
                ans++;
            }
        }

        return ans;
    }

    public void appendNumber(int cnt, String str) {
        if (cnt > stringArr.length) {
            return;
        }
        if (!str.equals("")) {
            set.add(Integer.parseInt(str));
        }

        for (int i = 0; i < stringArr.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                appendNumber(cnt + 1, str + stringArr[i]);
                visited[i] = false;
            }
        }
        return;
    }

    public boolean isPrimeNumber(Integer integer) {
        if (integer < 2) return false;
        for (int i = 2; i < integer; i++) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }
}