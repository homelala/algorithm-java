package DFSBFS;

import java.util.Scanner;

public class Combination {
    static int n, m, result = 0;

    public static void solution1(int n, int m) {
        if (m == 1) {
            result += n;
        } else if (n == m) {
            result += 1;
        }else{
            solution1(n - 1, m - 1);
            solution1(n - 1, m);
        }
    }

    static int[][] dy;

    public static int solution2(int n, int m) {
        if (dy[n][m] > 0) {
            return dy[n][m];
        }
        if (n == m || m == 0) {
            return 1;
        }else{
            return dy[n][m] = solution2(n-1, m-1) + solution2(n-1, m);
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        solution1(n, m);
        System.out.println(result);
        dy= new int[n + 2][n + 2];
        System.out.println(solution2(n, m));
    }
}
