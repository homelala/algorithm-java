package sort;

import java.util.Arrays;
import java.util.Scanner;

//다시 풀어보기2
public class Stall2 {
    public static boolean count(int[] array, int mid, int m) {
        int cnt = 1;
        int beforeStall = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] - beforeStall >= mid) {
                cnt++;
                beforeStall = array[i];

                if (cnt == m) {
                    return true;
                }
            }
        }
        return true;
    }
    public static int  solution1(int n, int m, int[] inputArray) {
        int answer = 0;
        int min = 1;
        int max = Arrays.stream(inputArray).max().getAsInt() - Arrays.stream(inputArray).min().getAsInt();

        while (min <= max) {
            int mid = (min + max) / 2;
            if (count(inputArray, mid, m)) {
                answer = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
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
        Arrays.sort(inputArray);
        System.out.println(solution1(n, m, inputArray));

    }
}
