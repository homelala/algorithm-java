package array;

import java.util.Scanner;

public class Fibonacci {
    public static int[] solution1(int len) {
        int[] result = new int[len];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < len; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        for (int i : solution1(len)) {
            System.out.print(i + " ");
        }
    }
}
