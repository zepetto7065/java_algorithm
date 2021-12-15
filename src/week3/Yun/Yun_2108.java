package week3.Yun;

import java.util.*;

public class Yun_2108 {
    public static void main(String[] args) {

        int maxValue = -4001;
        int minValue = 4001;

        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();

        int[] array = new int[numberOfElements];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            maxValue = Math.max(maxValue, array[i]);
            minValue = Math.min(minValue, array[i]);
        }

        Arrays.sort(array);

        Map<Integer, Integer> hashMap = new HashMap<>();


        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(array[i]) == null) {
                hashMap.put(array[i], 1);
                continue;
            }
            int newValue = hashMap.get(array[i]) + 1; //아직 초기화 안해줬는데 괜찮나..?
            hashMap.put(array[i], newValue);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        int mode = getMode(list);


        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double arithmeticMean = sum / (double) numberOfElements;
        arithmeticMean = Math.round(arithmeticMean);

        int median = array[(numberOfElements - 1) / 2];

        int range = maxValue - minValue;

        System.out.println((int) arithmeticMean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);

    }

    private static int getMode(List<Map.Entry<Integer, Integer>> list) {
        int mode = 0;
        if (list.size() == 1) {
            return list.get(0).getKey();
        }
        if (list.size() == 2) {
            return list.get(1).getKey();
        }
        int firstValue = list.get(list.size() - 1).getValue();
        int secondValue = list.get(list.size() - 2).getValue();
        int newNumber;


        if (firstValue == secondValue) {
            mode = list.get(list.size() - 1).getKey();
            for (int i = 3; i <= list.size(); i++) {
                newNumber = list.get(list.size() - i).getValue();

                if (i == list.size()) {
                    mode = list.get(1).getKey();
                    break;
                }

                if (firstValue == newNumber) {
                    continue;
                }

                mode = list.get(list.size() - i + 2).getKey();

            }
        } else {
            mode = list.get(list.size() - 1).getKey();
        }
        return mode;
    }
}
