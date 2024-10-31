package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 다시 풀어보기
public class SalesKind {
    public static ArrayList<Integer> solution1(int len, int k , int[] inputArray) {
        int lt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(inputArray[i], map.getOrDefault(inputArray[i], 0) + 1);
        }

        for (int rt = k - 1; rt < len; rt++) {
            map.put(inputArray[rt], map.getOrDefault(inputArray[rt], 0) + 1);
            result.add(map.size());
            map.put(inputArray[lt], map.getOrDefault(inputArray[lt], 0) - 1);
            if (map.get(inputArray[lt]) == 0) {
                map.remove(inputArray[lt]);
            }
            lt++;
        }

        return result;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        int[] inputArray = new int[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = in.nextInt();
        }

        for (int i : solution1(len, k, inputArray)) {
            System.out.print(i +" ");
        }

    }
}
