package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 백준 2309 일곱난쟁이
public class SevenDwarf {
    static int[] ch;
    static boolean flag = false;

    public static void getDwarf(int[] inputArray, int l, int[] dwarfs) {
        if (flag) {
            return;
        }
        if (l == 7) {
            if (checkDwarf(dwarfs)) {
                flag = true;
                for (int i : dwarfs) {
                    System.out.println(i);
                }
            }
        } else {
            for (int i = l; i < 9; i++) {
                if (ch[i] == 0) {
                    dwarfs[l] = inputArray[i];
                    ch[i] = 1;
                    getDwarf(inputArray, l + 1, dwarfs);
                    ch[i] = 0;
                }

            }
        }
    }

    public static boolean checkDwarf(int[] dwarfs) {
        int sum = 0;
        for (int i : dwarfs) {
            sum += i;
            if (sum > 100) {
                return false;
            }
        }
        return sum == 100;
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] inputArray = new int[9];
        ch = new int[9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArray);
        getDwarf(inputArray, 0, new int[7]);
        bw.flush();
        bw.close();
        br.close();

    }
}
