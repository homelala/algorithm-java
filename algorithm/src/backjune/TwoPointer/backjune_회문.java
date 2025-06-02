package backjune.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class backjune_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            answer.append(check(str, sb)).append("\n");
        }

        bw.write(answer + "");
        bw.flush();
    }

    private static int check(String str, StringBuilder sb) {
        if (str.equals(sb.reverse().toString())) {
            return 0;
        }
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                StringBuilder leftStr = new StringBuilder(str).deleteCharAt(left);
                StringBuilder rightStr = new StringBuilder(str).deleteCharAt(right);

                if (leftStr.toString().equals(leftStr.reverse().toString()) || rightStr.toString().equals(rightStr.reverse().toString())) {
                    return 1;
                }
                break;
            }
            left++;
            right--;
        }
        return 2;
    }
}
