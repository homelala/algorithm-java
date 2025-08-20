package backjune.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjune_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Double> scoreMap = new HashMap<>();
        scoreMap.put("A+", 4.5);
        scoreMap.put("A0", 4.0);
        scoreMap.put("B+", 3.5);
        scoreMap.put("B0", 3.0);
        scoreMap.put("C+", 2.5);
        scoreMap.put("C0", 2.0);
        scoreMap.put("D+", 1.5);
        scoreMap.put("D0", 1.0);
        scoreMap.put("F", 0.0);
        double sum = 0;
        double count = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String score = st.nextToken();

            if (!score.equals("P")) {
                sum += (grade * scoreMap.get(score));
                count += grade;
            }
        }

        System.out.println(sum / count);
    }
}
