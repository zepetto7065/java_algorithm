package week12.Yun;

public class Yun_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] lostArr = new int[n + 2];
        int[] reserveArr = new int[n + 2];

        for (int i = 0; i < lost.length; i++) {
            lostArr[lost[i]]++;
        }
        for (int i = 0; i < reserve.length; i++) {
            reserveArr[reserve[i]]++;
        }

        int recovery = 0;
        for (int i = n; i >= 1; i--) {
            if (lostArr[i] == 0) {
                continue;
            }

            if (reserveArr[i] == 1) {
                recovery++;
                reserveArr[i]--;
                lostArr[i]--;
            }
        }

        for (int i = n; i >= 1; i--) {
            if (lostArr[i] == 0) {
                continue;
            }

            if (reserveArr[i + 1] == 1) {
                recovery++;
                reserveArr[i + 1]--;
                continue;
            }
            if (reserveArr[i - 1] == 1) {
                recovery++;
                reserveArr[i - 1]--;
                continue;
            }
        }

        return n - lost.length + recovery;
    }

}
