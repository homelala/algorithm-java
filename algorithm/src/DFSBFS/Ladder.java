package DFSBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 15864 사다리
public class Ladder {
    static int n, m, h;
    static int[][] board;
    static boolean flag = false;
    public static void getLine(int l, int max) {
        if (flag || l > 3) {
            return;
        }

        if (l == max) {
            if (checkLadder()) {
                flag = true;
                System.out.println(l);
                return;
            }
        }else{
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j < n; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        getLine(l + 1, max);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static boolean checkLadder() {
        for(int i=1; i<=n; i++) {
            int line = i;
            int col = 1;
            while(true) {
                if(col == h+1) {
                    break;
                }
                if(board[col][line]==1) {
                    line+=1;
                }
                else if(board[col][line-1] ==1) {
                    line -=1;
                }
                col++;
            }
            if(line != i) {
                return false;
            }
        }
        return true;
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
        }

        for (int i = 0; i <= 3; i++) {
            if (flag) {
                break;
            }
            getLine(0, i);
        }
        if (!flag) {
            System.out.print("-1");
        }

        bw.newLine();
        bw.flush();
        bw.close();
    }
}
