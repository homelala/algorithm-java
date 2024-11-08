package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CommonCheck {
    public static Character solution1(int n, int[] inputArray) {
        Arrays.sort(inputArray);
        for (int i = 0; i < n - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                return 'D';
            }
        }
        return 'U';
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

       System.out.print(solution1(n, inputArray));

    }
}
