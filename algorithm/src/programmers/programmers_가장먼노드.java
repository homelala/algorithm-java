package programmers;

import java.util.*;

public class programmers_가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] lists = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] i : edge) {
            lists[i[0]].add(i[1]);
            lists[i[1]].add(i[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        distance[1] = 0;
        int dis = 0;

        while (!q.isEmpty()) {
            dis++;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int cur = q.poll();
                for (int i : lists[cur]) {
                    if (!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                        distance[i] = Math.min(distance[i], dis);
                    }
                }
            }
        }

        Arrays.sort(distance);
        int max = distance[n];
        for (int i = n; i > 0; i--) {
            if (distance[i] != max) {
                break;
            }else{
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
