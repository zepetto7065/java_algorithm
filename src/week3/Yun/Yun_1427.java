package week3.Yun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Yun_1427 { // 17660	228
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

        Integer[] arrayOfN = new Integer[n.length()];

        for (int i = 0; i < arrayOfN.length; i++) {
            arrayOfN[i] = Integer.parseInt(n.substring(i, i + 1));
        }

        Arrays.sort(arrayOfN, new Decending());

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < arrayOfN.length; i++) {
            stringBuffer.append(arrayOfN[i]);
        }

        System.out.println(stringBuffer);

    }
}

class Decending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c2.compareTo(c1);
        }
        return -1;
    }

}