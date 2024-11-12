package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static void solution1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n+ " ");
        solution1(n - 1);
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        solution1(n);
    }
}
