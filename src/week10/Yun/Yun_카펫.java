package week10.Yun;

public class Yun_카펫 {
    public int[] solution(int brown, int yellow) {
        int distance = (brown - 8) / 2;
        int garo = 1 + distance;
        int sero = 1;

        for (; ; ) {
            if (garo * sero == yellow) {
                break;
            }

            garo -= 1;
            sero += 1;
        }
        return new int[]{garo + 2, sero + 2};
    }
}