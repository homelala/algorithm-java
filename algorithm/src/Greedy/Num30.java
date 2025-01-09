package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;

// 10610 30
public class Num30 {

    static Character[] arr;
    public static String solution1() {
        if (!Arrays.stream(arr).anyMatch(value -> value == '0')) {
            return "-1";
        }

        int sum = 0;
        for (char c : arr) {
            sum += (int) c;
        }

        if (sum % 3 != 0) {
            return "-1";
        }

        String result = "";
        for (Character c : arr) {
            result += c;
        }

        return result;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        arr = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(solution1());
    }
}
