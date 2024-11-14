package Recursion;

import java.util.Scanner;
class Node{
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class BinaryTree {
    Node root;

    public void dfs(Node root) {
        if (root == null) { // 말단 노드일 경우
            return;
        }else{ // 왼쪽 노드로 향하는 경우
//            System.out.print(root.data+" "); // 전위 순회
            dfs(root.lt);
//            System.out.print(root.data+" ");// 중위 순회
            dfs(root.rt);
            System.out.print(root.data+" ");// 후위 순회
        }
    }

    public void main() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }
}
