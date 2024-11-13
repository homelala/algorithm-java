package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static void solution1(int n) {
        if (n == 0) {
            return;
        }
        solution1(n - 1);
        System.out.print(n+ " ");
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        solution1(n);
    }
}
