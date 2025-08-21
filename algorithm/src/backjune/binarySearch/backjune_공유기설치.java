package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            houses[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(houses);

        int min = 1;
        int max = houses[houses.length - 1] - houses[0];

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = getDis(mid, houses);
            if (count < c) {
                max = mid - 1;
            }else{
                answer = mid;
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int getDis(int mid, int[] houses) {
        int count = 1;
        int last = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] >= last + mid) {
                count++;
                last = houses[i];
            }
        }

        return count;
    }
}
