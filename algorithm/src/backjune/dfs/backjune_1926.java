package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class backjune_1926 {
    static int count = 0;
    static int maxSize = 0;


    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    arr[i][j] = 2;
                    maxSize = Math.max(maxSize, dfs(arr, n, m, i, j, 1));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int dfs(int[][] arr, int n, int m, int x, int y, int size) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >=0 && nx <n && ny <m && arr[nx][ny] == 1) {
                arr[nx][ny] = 2;
                size = dfs(arr, n, m, nx, ny, size+1);
            }
        }

        return size;
    }
}
