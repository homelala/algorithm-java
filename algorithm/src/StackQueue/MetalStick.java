package StackQueue;

import java.util.Scanner;
import java.util.Stack;

//다시 풀어보기
public class MetalStick {
public static int solution1(String inputString) {
    int result = 0;
        Stack<Character> stack = new Stack<>();
    for (int i = 0; i < inputString.length(); i++) {
        if (inputString.charAt(i) == '(') {
            stack.push(inputString.charAt(i));
        } else {
            stack.pop();
            if (inputString.charAt(i - 1) == '(') {
                result += stack.size();
            }else{
                result += 1;
            }
        }
    }
        return result;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();

        System.out.println(solution1(inputString));
    }
}
