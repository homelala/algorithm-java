package StackQueue;

import java.util.*;

public class Parentheses {
    public static String solution1(String inputString) {
        Stack<Character> stack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (String.valueOf(c).equals(")")) {
                if (String.valueOf(stack.peek()).equals("(")) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    public static String solution2(String inputString) {
        Stack<Character> stack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }else{
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();

        System.out.println(solution1(inputString));
    }
}
