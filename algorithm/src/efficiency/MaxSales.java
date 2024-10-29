package efficiency;

import java.util.Scanner;

public class MaxSales {
    public static int solution1(int totalDate, int countDate, int[] inputArray) {
        int result = inputArray[0];
        int[] historySale = new int[totalDate];
        historySale[0] = inputArray[0];
        for (int i = 1; i < countDate; i++) {
            historySale[i] += historySale[i - 1] + inputArray[i];
            result += inputArray[i];
        }

        for (int i = countDate; i < totalDate; i++) {
            historySale[i] = historySale[i-1] - inputArray[i - countDate] + inputArray[i];
            result = Math.max(result, historySale[i]);
        }
        return result;
    }

     public static int solution2(int totalDate, int countDate, int[] inputArray) {
        int result, sum = 0;
        for (int i = 0; i < countDate; i++) {
            sum += inputArray[i];
        }
         result = sum;
        for (int i = countDate; i < totalDate; i++) {
            sum = sum - inputArray[i - countDate] + inputArray[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int totalDate = in.nextInt();
        int countDate = in.nextInt();

        int[] inputArray = new int[totalDate];
        for (int i = 0; i < totalDate; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.print(solution2(totalDate, countDate, inputArray));
    }
}
