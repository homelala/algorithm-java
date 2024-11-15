package sort;

import java.util.Arrays;
import java.util.Scanner;

//다시 풀어보기
public class BinarySort2 {
    public static int  solution1(int n, int m, int[] inputArray) {
        Arrays.sort(inputArray);
//        return Arrays.binarySearch(inputArray, m) + 1;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (inputArray[mid] == m) {
                return mid;
            }
            if (inputArray[mid] > m) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.println(solution1(n, m, inputArray)+1);

    }
}
