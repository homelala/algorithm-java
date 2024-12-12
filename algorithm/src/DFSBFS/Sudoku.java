package DFSBFS;

import java.io.*;
import java.util.*;

//백준 2580 스도쿠
// 다시 풀어보기
public class Sudoku {

    static int[][] arr;

    public static boolean isPossible(int x, int y, int value) {
        for(int i = 0; i < 9; i++){
            if(arr[x][i] == value){
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if (arr[i][y] == value) {
                return false;
            }
        }

        int rowLocation = (x/3)*3;
        int colLocation = (y/3)*3;

        for(int i = rowLocation; i < rowLocation+3; i++){
            for(int j = colLocation; j < colLocation+3; j++){
                if(arr[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void solution1(int row, int col) {
        if (col == 9) {
            solution1(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    solution1(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        solution1(row, col + 1);
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution1(0, 0);

        for(int[] a: arr){
            for (int i : a) {
                bw.write(i + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
