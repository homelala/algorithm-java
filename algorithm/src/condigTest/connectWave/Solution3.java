package condigTest.connectWave;

public class Solution3 {
    public static long solution(long a, long b) {
        long mod = 100000L;
        long result = modPow(a, b, mod);

        return result;
    }

    // 빠른 거듭제곱 (a^b % mod)
    private static long modPow(long base, long exp, long mod) {
        long result = 1;

        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // 홀수일 때
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // exp /= 2
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 26));               // 8864
        System.out.println(solution(123456789L, 12345L));    // 38549
    }
}
