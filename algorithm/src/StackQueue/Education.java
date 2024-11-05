package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Education {
    public static String solution1(String inputStringA, String inputStringB) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : inputStringA.toCharArray()) {
            if (!inputStringB.contains(String.valueOf(c))) return "NO";
        }

        for (char c : inputStringB.toCharArray()) {
            queue.offer(c);
            if (inputStringA.contains(String.valueOf(c))) {
                for (char ct : inputStringA.substring(0, inputStringA.indexOf(c)).toCharArray()) {
                    if(!queue.contains(ct)) return "NO";
                }
            }
        }

        return "YES";
    }

     public static String solution2(String inputStringA, String inputStringB) {
        Queue<Character> queue = new LinkedList<>();
         for (char c : inputStringA.toCharArray()) {
             queue.offer(c);
         }
         for (char c : inputStringB.toCharArray()) {
             if (queue.contains(c)) {
                 if (queue.poll() != c) {
                     return "NO";
                 }
             }
         }

         if (!queue.isEmpty()) return "NO";
        return "YES";
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        String inputStringA = in.nextLine();
        String inputStringB = in.nextLine();

        System.out.println(solution2(inputStringA, inputStringB));
    }
}
