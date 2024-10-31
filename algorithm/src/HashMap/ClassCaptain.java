package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ClassCaptain {
    public static Character solution1(int len, String inputString) {
        Character result = null;
        int maxVoteCount = 0;
        HashMap<Character, Integer> voteInfo = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            voteInfo.put(c, voteInfo.getOrDefault(c,0) + 1);
        }

        for (char c: voteInfo.keySet()) {
            if (maxVoteCount < voteInfo.get(c)) {
                maxVoteCount = voteInfo.get(c);
                result = c;
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        String inputString = in.next();

        System.out.print(solution1(len, inputString));
    }
}
