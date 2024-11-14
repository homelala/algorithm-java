package Recursion;

import java.util.LinkedList;
import java.util.Queue;

//class Node{
//    int data;
//    Node lt, rt;
//
//    public Node(int val) {
//        data = val;
//        lt = rt = null;
//    }
//}
public class BFS {
    Node root;

    public void bfs(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int l = 0;
        while (!Q.isEmpty()) {
            System.out.print(l + ": ");
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            l++;
            System.out.println();
        }
    }

    public void main() {
        BFS tree = new BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }
}