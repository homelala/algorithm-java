package DFSBFS;

import java.util.*;

public class EqualSumSubset {
    static int n = 0;
    static int[] ch, array;
    static String answer = "NO";
    static boolean flag = false;

    public static void solution1(int v, int sum) {
        if(flag){
            return;
        }
        if (v>sum) {
            return;
        }else if (v == sum) {
            flag = true;
            answer = "YES";
            return;
        }else{
            for (int i = 1; i < n; i++) {
                if (ch[i+1] == 0) {
                   ch[i + 1] = 1;
                    solution1(v + array[i], sum - array[i]);
                    ch[i + 1] = 0;
                }
            }
        }
    }

    static int total = 0;
    public static void solution2(int l, int sum, int[] array) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (l == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }else{
            solution2(l + 1, sum + array[l], array);
            solution2(l + 1, sum, array);
        }
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        ch = new int[n+1];
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            total += array[i];
        }
        int sum = Arrays.stream(array).sum();
        ch[1] = 1;
        solution1(1, sum - 1);
        System.out.print(answer);
        solution2(0, 0, array);
        System.out.print(answer);

    }
}
