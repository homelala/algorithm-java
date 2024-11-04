package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public static String solution1(String inputString) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                if (stack.isEmpty()) {
                    result += c;
                }
            }else{
                if (c == '(') {
                stack.push(c);
                }else{
                    stack.pop();
                }
            }
        }

        return result;
    }

    public static String solution2(String inputString) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c) || c == '(') {
                stack.push(c);
            }else{
                while (stack.pop()!='(') {
                }
            }
        }
        for (char c : stack) {
            result += c;
        }
        return result;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();

        System.out.println(solution2(inputString));
    }
}
