package Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDFS {
    Node root;

    public int dfs(int l, Node root) {
        if (root.lt == null && root.rt == null) {
            return l;
        }else{
            return Math.min(dfs(l + 1, root.lt), dfs(l + 1, root.rt));
        }
    }

    public void main() {
        TreeDFS tree = new TreeDFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.dfs(0, tree.root));
    }
}
