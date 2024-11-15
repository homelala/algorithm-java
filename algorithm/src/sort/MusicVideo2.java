package sort;

import java.util.Arrays;
import java.util.Scanner;

//다시 풀어보기
public class MusicVideo2 {
    public static int count(int[] array, int mid) {
        int cnt = 1;
        int sum = 0;
        for (int i : array) {
            if (sum+i > mid) {
                cnt++;
                sum = i;
            }else{
                sum += i;
            }
        }
        return cnt;
    }
    public static int  solution1(int n, int m, int[] inputArray) {
        int answer = 0;
        int low = Arrays.stream(inputArray).max().getAsInt();
        int high = Arrays.stream(inputArray).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = count(inputArray, mid);
            if (cnt <= m) {
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
