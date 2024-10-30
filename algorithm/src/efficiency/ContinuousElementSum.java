package efficiency;

import java.util.Scanner;

public class ContinuousElementSum {
    public static int solution1(int n) {
        int result = 0, sum = 0, len = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            len ++;
            if (sum == n && len > 1) {
                result++;
            }else{
                while (sum > n) {
                    sum -= i - (len - 1);
                    len--;
                }
                if (sum == n && len > 1) {
                    result++;
                }
            }
        }

        return result;
    }
    public static int solution2(int n) {
        int result = 0, sum = 0, lt = 0, rt = 0;
        int m = n / 2 + 1;
        int[] halfArray = new int[m];
        for (int i = 0; i < m; i++) {
            halfArray[i] = i + 1;
        }

        while (rt < m) {
            sum += halfArray[rt];
            rt++;
            if (sum == n) {
                result++;
            }
            while (sum > n) {
                sum -= halfArray[lt];
                lt++;
                if (sum == n) {
                    result++;
                }
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        System.out.print(solution2(n));
    }
}
