package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WordSort {

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] inputArray = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = st.nextToken();
        }
        String[] sortArr = Arrays.stream(inputArray).distinct().toArray(String[]::new);
        Arrays.sort(sortArr, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        for (String i : sortArr) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
