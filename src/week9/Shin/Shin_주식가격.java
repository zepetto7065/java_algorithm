package week9.Shin;

public class Shin_주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        for (int i : solution(prices)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        int priceLength = prices.length;
        int[] times = new int[priceLength];

        for (int i = 0; i < priceLength - 1; i++) {
            int time = 0;
            for (int j = i + 1; j < priceLength; j++) {
                if (prices[i] > prices[j]) {
                    time = j - i;
                    break;
                }

                time = j - i;
            }
            times[i] = time;
        }
        return times;
    }
}
