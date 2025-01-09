package Greedy;

import java.io.*;
import java.util.*;

import static java.lang.System.in;

// 1202 보석 도둑
public class SteelJewel {
    public static class Jewel {
        int weight;
        int cost;

        public Jewel(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    static int n, k;
    static int[] bags;
    static ArrayList<Jewel> jewels;
    static PriorityQueue<Integer> pq;

    public static long solution1() {
        long answer = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n) {
                if (bags[i] < jewels.get(j).weight) {
                    break;
                }else{
                    pq.add(jewels.get(j).cost);
                    j++;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new ArrayList<>();
        bags = new int[k];
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(a, b));
        }
        jewels.sort(Comparator.comparing(((Jewel jewel) -> jewel.weight)).thenComparing(((Jewel jewel) -> jewel.cost), Collections.reverseOrder()));

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bags);

        System.out.println(solution1());
    }
}
