package StackQueue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Crane {
    public static int solution1(int len, int[][] board, int M, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Stack<Integer>> stackBoard = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            Stack<Integer> row = new Stack<>();
            for (int j = len-1; j >0; j--) {
                if (board[j][i]==0) {
                    continue;
                }
                row.add(board[j][i]);
            }
            stackBoard.add(row);
        }

        for (int i : moves) {
            if (stackBoard.get(i - 1).isEmpty()) {
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(stackBoard.get(i - 1).pop());
                continue;
            }

            if (stack.peek() == stackBoard.get(i - 1).peek()) {
                stackBoard.get(i - 1).pop();
                stack.pop();
                result+=2;
            }else{
                stack.push(stackBoard.get(i - 1).pop());
            }
        }
        return result;
    }

    public static int solution2(int len, int[][] board, int M, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            for (int j = 0; j < len; j++) {
                if (board[j][i - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][j - 1]) {
                            result += 2;
                            stack.pop();
                    }else{
                        stack.push(board[i][j - 1]);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[][] board = new int[len][len];
        for (int i = 0; i <len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int M = in.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = in.nextInt();
        }

        System.out.println(solution1(len, board, M, moves));
    }
}
