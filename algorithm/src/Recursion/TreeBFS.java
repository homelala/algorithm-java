package Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    Node root;

    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) {
                    return l;
                }else{
                    if (cur.lt != null) {
                        queue.offer(cur.lt);
                    }
                    if (cur.rt != null) {
                        queue.offer(cur.rt);
                    }
                }
            }
            l++;
        }
        return l;
    }

    public void main() {
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.bfs(tree.root));
    }
}
