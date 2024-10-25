package array;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseDecimal {
    public static ArrayList<Integer> solution1(int len, StringBuilder[] inputArray) {
        ArrayList<Integer> result = new ArrayList<>();
        for (StringBuilder i : inputArray) {
            boolean isPrime = true;
            int reverseInteger = Integer.parseInt(i.reverse().toString());

            if (reverseInteger <= 1) {
                continue;
            }

            for (int j = 2; j <= Math.sqrt(reverseInteger); j++) {
                if (reverseInteger % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result.add(reverseInteger);
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        StringBuilder[] inputArray = new StringBuilder[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = new StringBuilder(Integer.toString(in.nextInt()));
        }
        for (int i : solution1(len, inputArray)) {
            System.out.print(i + " ");
        }
    }
}
