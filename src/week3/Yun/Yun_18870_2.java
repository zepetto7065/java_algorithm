package week3.Yun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Yun_18870_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfX = scanner.nextInt();

        XPosition[] Xs = new XPosition[numberOfX];
        setXs(scanner, numberOfX, Xs);

        sortingByFirstX(Xs);

        int k = 0;
        Xs[0].second_x = k;
        int numberOfCheck = 1;
        setSecond_x(Xs, k, numberOfCheck);

        sortingByOrder(Xs);

        print(Xs);


    }

    private static void print(XPosition[] Xs) {
        for (int i = 0; i < Xs.length; i++) {
            System.out.print(Xs[i].second_x + " ");
        }
    }

    private static void sortingByOrder(XPosition[] Xs) {
        Arrays.sort(Xs, new Comparator<XPosition>() {
            @Override
            public int compare(XPosition o1, XPosition o2) {
                return o1.order - o2.order;
            }
        });
    }

    private static void setSecond_x(XPosition[] Xs, int k, int numberOfCheck) {
        for (int i = 1; i < Xs.length; i++) {
            if (Xs[i].first_x == Xs[i - 1].first_x) {
                Xs[i].second_x = Xs[i - 1].second_x;
                numberOfCheck++;

            }

            if (Xs[i].first_x != Xs[i - 1].first_x) {
                k++;
                Xs[i].second_x = k;
                numberOfCheck++;
            }

            if (numberOfCheck == Xs.length) {
                break;
            }
        }
    }

    private static void sortingByFirstX(XPosition[] Xs) {
        Arrays.sort(Xs, new Comparator<XPosition>() {
            @Override
            public int compare(XPosition o1, XPosition o2) {
                if (o1.first_x > o2.first_x) {
                    return 1;
                }
                return -1;
            }
        });
    }

    private static void setXs(Scanner scanner, int numberOfX, XPosition[] Xs) {
        for (int i = 0; i < numberOfX; i++) {
            Xs[i] = new XPosition(scanner.nextInt(), i);
        }
    }
}

class XPosition {
    long first_x;
    int second_x;
    int order;

    XPosition(long first_x, int order) {
        this.first_x = first_x;
        this.order = order;
    }
}
