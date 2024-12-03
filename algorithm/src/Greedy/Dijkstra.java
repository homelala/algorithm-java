package Greedy;

import java.util.*;

public class Dijkstra {
    static class Node implements Comparable<Node>{
        int vex;
        int cost;

        public Node(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] dis;

    public static void solution1(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(n, 0));
        dis[n] = 0;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int nowVex = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[nowVex]) {
                continue;
            }
            for (Node node : graph.get(n)) {
                if (dis[node.vex] > nowCost + node.cost) {
                    dis[node.vex] = nowCost + node.cost;
                    queue.add(new Node(node.vex, nowCost + node.cost));
                }
            }
        }
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Node(b, c));
        }
        solution1(n);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + ": " + dis[i]);
            }else{
                System.out.println(i+": "+ "impossible");
            }
        }
    }
}
