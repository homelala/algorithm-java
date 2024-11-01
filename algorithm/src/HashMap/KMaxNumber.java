package HashMap;

import java.util.*;

public class KMaxNumber {
    public static int solution1(int n, int k, int[] inputArray) {
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int x = j + 1; x < n; x++) {
                    tree.add(inputArray[i] + inputArray[j] + inputArray[x]);
                }
            }
        }
        int cnt = 0;
        for (int i : tree) {
            cnt++;
            if (cnt == k) {
                return i;
            }
        }

        return -1;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.print(solution1(n, k, inputArray));

    }
}
