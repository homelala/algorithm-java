package Greedy;

import java.io.*;
import java.util.StringTokenizer;

// 백준 1541 잃어버린 괄호
// 다시 풀어보기
public class MissingParentheses {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] subPart = br.readLine().split("-");
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < subPart.length; i++) {
            int temp = 0;
            String[] addPart = subPart[i].split("\\+");

            for (int j = 0; j < addPart.length; j++) {
                temp += Integer.parseInt(addPart[j]);
            }
            if (answer == Integer.MAX_VALUE) {
                answer = temp;
            }else{
                answer -= temp;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
