package array;

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mentoring {
    public static int solution1(int testCount, int studentCount, int[][] inputArray) {
        int result = 0;
        ArrayList<ArrayList<Integer>> lowerScoreStudent = new ArrayList<>();

        for(int j=0;j<studentCount; j++){
            ArrayList<Integer> mentiStudent = new ArrayList<>();
            for (int i = 0; i < studentCount; i++) {
                if (i == j) {
                    continue;
                }
                mentiStudent.add(i+1);
            }
            lowerScoreStudent.add(mentiStudent);
        }

        for (int i = 0; i < testCount; i++) {
            for (int j = studentCount - 1; j >= 0; j--) { //멘토학생
                for (int x = j-1; x >=0; x--) {//멘티학생비교 후 제거
                    lowerScoreStudent.get(inputArray[i][j] - 1).remove(Integer.valueOf(inputArray[i][x]));
                }
            }
        }
        for (ArrayList<Integer> lowerStudent : lowerScoreStudent) {
            result += lowerStudent.size();
        }
        return result;
    }

    public static int solution2(int testCount, int studentCount, int[][] inputArray) {
        int result = 0;

        for (int i = 0; i <studentCount; i++) {//멘토 학생
            for (int j = 0; j < studentCount; j++) {//멘티학생
                if (i == j) {
                    continue;
                }
                boolean isMento = true;
                for (int k = 0; k < testCount; k++) {//시험 횟수
                    int pi = 0, pj = 0;
                    for (int s = 0; s < studentCount; s++) { //해당 시험에서 등수확인
                        if (inputArray[k][s] - 1 == i) {
                            pi = s;
                        }
                        if (inputArray[k][s] - 1 == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        isMento = false;
                        break;
                    }
                }
                if (isMento) {
                    result++;
                }
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int studentCount = in.nextInt();
        int testCount = in.nextInt();
        int[][] inputArray = new int[testCount][studentCount];

        for (int i = 0; i < testCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                inputArray[i][j] = in.nextInt();
            }
        }
        System.out.println(solution2(testCount, studentCount, inputArray));
    }
}
