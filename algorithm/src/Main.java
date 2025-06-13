
import condigTest.devsisters.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        test3 test3 = new test3();
        System.out.println(test3.solution(new String[]{"cab", "adaaa", "e"})); // 3
        System.out.println(test3.solution(new String[]{"aabb", "baba"})); // 0
        System.out.println(test3.solution(new String[]{"a", "a", "e", "d", "abdce"}));
        System.out.println(test3.solution(new String[]{"a"}));

    }
}