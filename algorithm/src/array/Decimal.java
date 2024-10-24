package array;

import java.util.Scanner;

public class Decimal {
    public static int solution2(int len) {
        // 특정 숫자가 소수인지 확인하고
        // 만일 소수라면 해당 소수의 배수를 소수가 아닌걸로 체크

        int result = 0;
        int[] intArray = new int[len + 1];
        for (int i = 2; i < len; i++) {
            if (intArray[i] == 0) {
                result++;
                for (int j = i; j < len; j+=i) {
                    intArray[j] = 1;
                }
            }
        }

        return result;
    }
    public static int solution1(int len) {
        int result = 0;

        for (int i = 2; i < len; i++) {
            boolean isPrime = true;
            for (int x = 2; x <= Math.sqrt(i); x++) {
                if (i % x == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                result++;
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        System.out.println(solution2(len));
    }
}
