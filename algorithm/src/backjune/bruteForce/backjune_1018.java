package backjune.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_1018 {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int total = getColor(board, i, j);
                result = Math.min(result, total);
            }
        }
        System.out.println(result);
    }

    private static int getColor(char[][] board, int x, int y) {
        int result = 0;
        String orgBoard[] = {"WBWBWBWB", "BWBWBWBW"};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != orgBoard[i % 2].charAt(j)) {
                    result++;
                }
            }
        }

        return Math.min(result, 64 - result);
    }
}
