package programmers;

public class programmers_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};

        int left = 0;
        int right = -1;
        int sum = 0;

        while (left < sequence.length && right < sequence.length) {
            if (sum == k) {
                if (answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
            }else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}
