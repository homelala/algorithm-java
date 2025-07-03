package backjune.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class backjune_캠핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l==0 && p ==0 && v==0) break;

            int mod = v / p;
            int answer = (mod * l);

            answer += Math.min(v % p, l);

            sb.append("Case ").append(caseNum++).append(": ").append(answer).append("\n");
        }
        bw.append(sb);
        bw.flush();
        bw.close();

    }
}
