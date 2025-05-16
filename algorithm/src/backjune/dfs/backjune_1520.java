package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_1520 {
    static int result = 0;
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[a][b];
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < b; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());;
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(a, b, 0, 0, arr, dp));
    }

    private int dfs(int a, int b, int x, int y, int[][] arr, int[][] dp) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if (x == a - 1 && y == b - 1) {
            return 1;
        } else {
            if (dp[x][y] == -1) {
                dp[x][y] = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < a && ny < b && arr[nx][ny] < arr[x][y]) {
                        dp[x][y] += dfs(a, b, nx, ny, arr, dp);
                    }
                }
            }
        }

        return dp[x][y];
    }
}
