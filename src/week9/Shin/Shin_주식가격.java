package week9.Shin;

import java.util.Stack;

// 주식 가격: https://programmers.co.kr/learn/courses/30/lessons/42584
public class Shin_주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        for (int i : solution1(prices)) {
            System.out.println(i);
        }

        for (int i : solution2(prices)) {
            System.out.println(i);
        }
    }

    public static int[] solution1(int[] prices) {
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

    public static int[] solution2(int[] prices) {
        int priceLength = prices.length;
        Stack<Integer> beginIdxs = new Stack<>();
        int[] terms = new int[priceLength];

        beginIdxs.push(0);
        for (int i = 1; i < priceLength; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = priceLength - beginIdx - 1;
        }

        return terms;
    }
}
