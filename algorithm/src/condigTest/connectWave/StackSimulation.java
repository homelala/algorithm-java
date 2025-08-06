package condigTest.connectWave;

import java.util.Stack;

public class StackSimulation {
    public static boolean solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int index = 0; // arr에서 비교할 인덱스
        int next = 1; // 스택에 넣을 다음 숫자 (1부터 N까지)

        while (next <= n) {
            stack.push(next); // 다음 숫자 push
            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                index++;
                if (index == n) break;
            }
            next++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2}));
        System.out.println(solution(new int[]{3, 1, 2}));
    }
}
