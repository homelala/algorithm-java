package programmers;

public class programmers_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] board = new int[N][N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < road.length; i++) {
            if(board[road[i][0] - 1][road[i][1] - 1] != 0){
                board[road[i][0] - 1][road[i][1] - 1] = Math.min(board[road[i][0] - 1][road[i][1] - 1], road[i][2]);
                board[road[i][1] - 1][road[i][0] - 1] = Math.min(board[road[i][1] - 1][road[i][0] - 1], road[i][2]);
            }
            else{
                board[road[i][0] - 1][road[i][1] - 1] = road[i][2];
                board[road[i][1] - 1][road[i][0] - 1] = road[i][2];
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) board[i][j] = 0;
                else if(board[i][j]==0) board[i][j] = 5000001;
            }
        }

        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = board[0][i];
        }

        visited[0] = true;

        for (int i = 0; i < N; i++) {
            int cur = getSmallIdx(distance, 0, visited);

            visited[cur] = true;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && distance[j] > distance[cur] + board[cur][j]) {
                    distance[j] = distance[cur] + board[cur][j];
                }
            }
        }

        for (int i : distance) {
            if (i <= K) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    private int getSmallIdx(int[] distance, int start, boolean[] visited) {
        int min = 500001;
        int idx = 0;

        for (int i = 0; i < distance.length; i++) {
            if(i==start) continue;
            if (min > distance[i] && !visited[i]) {
                idx = i;
                min = distance[i];
            }
        }

        return idx;
    }
}
