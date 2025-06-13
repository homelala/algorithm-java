

import condigTest.naver_cloud.test1;
import condigTest.naver_cloud.test2;
import condigTest.naver_cloud.test3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        test3 test3 = new test3();

        System.out.println(test3.solution(new int[]{3, 8, 2, 3, 3, 2})); // 3
        System.out.println(test3.solution(new int[]{7, 1, 2, 8, 2}));    // 2
        System.out.println(test3.solution(new int[]{3, 1, 4, 1, 5}));    // 0
        System.out.println(test3.solution(new int[]{5, 5, 5, 5, 5}));    // 5

    }
}