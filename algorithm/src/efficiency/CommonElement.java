package efficiency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElement {
    public static ArrayList<Integer> solution1(int lenA, int[] inputArrayA, int lenB, int[] inputArrayB) {
        /*
        1 2 3 5 9
        2 3 5 7 8
         */
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(inputArrayA);
        Arrays.sort(inputArrayB);
        int pa = 0, pb = 0;
        while (pa < lenA && pb < lenB) {
            if (inputArrayA[pa] == inputArrayB[pb]) {
                result.add(inputArrayA[pa]);
                pa++;
                pb++;
            }
            if (inputArrayA[pa] < inputArrayB[pb]) {
                pa++;
            }else{
                pb++;
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int lenA = in.nextInt();
        int[] inputArrayA = new int[lenA];
        for (int i = 0; i < lenA; i++) {
            inputArrayA[i] = in.nextInt();
        }

        int lenB = in.nextInt();
        int[] inputArrayB = new int[lenB];
        for (int i = 0; i < lenB; i++) {
            inputArrayB[i] = in.nextInt();
        }

        for (int i : solution1(lenA, inputArrayA, lenB, inputArrayB)) {
            System.out.print(i+" ");
        }
    }
}
