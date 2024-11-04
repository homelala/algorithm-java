package StackQueue;


import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static int solution1(String inputString) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (char i : inputString.toCharArray()) {
            if (Character.isDigit(i)) {
                stack.push(Character.getNumericValue(i));
            }else{
                int firstNum = stack.pop();
                int secondNum = stack.pop();
                if (i == '+') {
                    result = secondNum + firstNum;
                }else if (i == '-') {
                    result = secondNum - firstNum;
                }else if (i == '*') {
                    result = secondNum * firstNum;
                }else if (i == '/') {
                    result = secondNum / firstNum;
                }
                stack.push(result);
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
