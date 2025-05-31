package programmers;

public class programmers_연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int n = sequence.length;

        long maxSum1 = Long.MIN_VALUE;
        long maxSum2 = Long.MIN_VALUE;
        long currentSum1 = 0;
        long currentSum2 = 0;

        for (int i = 0; i < n; i++) {
            int sign1 = (i % 2 == 0) ? 1 : -1;  // [1, -1, 1, -1, ...]
            int sign2 = (i % 2 == 0) ? -1 : 1;  // [-1, 1, -1, 1, ...]

            long val1 = sequence[i] * sign1;
            long val2 = sequence[i] * sign2;

            currentSum1 = Math.max(val1, currentSum1 + val1);
            currentSum2 = Math.max(val2, currentSum2 + val2);

            maxSum1 = Math.max(maxSum1, currentSum1);
            maxSum2 = Math.max(maxSum2, currentSum2);
        }

        return Math.max(maxSum1, maxSum2);
    }
}
