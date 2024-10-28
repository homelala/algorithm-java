package efficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeArray {
    public static ArrayList<Integer> solution1(int lenA, int[] inputArrayA, int lenB, int[] inputArrayB) {
        ArrayList<Integer> result = new ArrayList<>();
        int x = 0, y = 0;
        while (x < lenA && y < lenB) {
            if (inputArrayA[x] > inputArrayB[y]) {
                result.add(inputArrayB[y]);
                y++;
            }else{
                result.add(inputArrayA[x]);
                x++;
            }
        }
        if (x >= lenA) {
            for (int i = y; i < lenB; i++) {
                result.add(inputArrayB[i]);
            }
        }
        if (y >= lenB) {
            for (int i = x; i < lenA; i++) {
                result.add(inputArrayA[i]);
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
