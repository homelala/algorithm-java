package StackQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 다시 풀어보기
public class EmergencyRoom {
    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static int solution1(int n, int m, Queue<Person>  queue) {
        int result = 0;

        while (true) {
            Person person = queue.poll();
            for (Person tmp : queue) {
                if (tmp.priority > person.priority) {
                    queue.offer(person);
                    person = null;
                    break;
                }
            }
            if (person != null) {
                result++;
                if (person.id == m) {
                    return result;
                }
            }
        }
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            queue.offer(new Person(i, temp));
        }

        System.out.println(solution1(n, m, queue));
    }
}
