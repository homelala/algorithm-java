package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Naughty {

    public static ArrayList<Integer> solution1(int n, int[] inputArray) {
        ArrayList<Integer> result = new ArrayList<>();
        int a=0, b=n;
        int[] temp = inputArray.clone();
        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if (temp[i] != inputArray[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        for (int i : solution1(n, inputArray)) {
            System.out.printf(i + " ");
        }

    }
}
