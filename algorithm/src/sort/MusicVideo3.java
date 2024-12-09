package sort;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo3 {
    public static int count(int mid, int m, int[] inputArray) {
        int count = 1, sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            if (sum > mid) {
                count++;
                sum = inputArray[i];
            }
        }
        return count;
    }

    public static int  solution1(int n, int m, int[] inputArray) {
        int answer = Integer.MAX_VALUE;
        int low = Arrays.stream(inputArray).max().getAsInt();
        int high = Arrays.stream(inputArray).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (count(mid, m, inputArray) <= m) {
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return answer;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.println(solution1(n, m, inputArray));

    }
}
