package sort;

import java.util.Scanner;

// 다시 풀어보기3
// key 값 전에 위치한 value 중 가장 작은 값을 찾아 바꾸는 것
// 스위칭을 하는 것이 아니라 말그대로 밀어내는 것이 중요
/*
 8
 5 9 3 1 4 2 8 7
 */
public class InsertSort6 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            int temp = inputArray[i]; // 기준 값을 저장
            int ind = i; // 순서를 바꿔줄 인덱스
            for (int j = i; j > 0; j--) { //기준 부터 끝까지
                if (temp < inputArray[j - 1]) { // 기준 값보다 작을 시 덮어 씌운다
                    ind = j - 1; // 덮어 씨운 위치 저장
                    inputArray[j] = inputArray[j - 1]; // 덮어 씌우기
                }else{
                    break; // 만일 클 경우 반복문 break 후 그 위치에 기준 값을 저장한다
                }
            }
            inputArray[ind] = temp;
        }

        return inputArray;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        for (int i : solution1(n, inputArray)) {
            System.out.print(i + " ");
        }
    }
}
