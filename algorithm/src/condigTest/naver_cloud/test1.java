package condigTest.naver_cloud;

public class test1 {
    public int solution(int N, String S) {
        int answer = 0;
        boolean[][] board = new boolean[N][10];

        String[] seated = S.split(" ");

        if (!S.isEmpty()) {
            for (String s : seated) {
                int len = s.length();
                int row = Integer.parseInt(s.substring(0, len - 1)) - 1;
                char seatChar = s.charAt(len - 1);
                int col = seatToIndex(seatChar);

                board[row][col] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!board[i][1] && !board[i][2] && !board[i][3] && !board[i][4]) {
                if (!board[i][5] && !board[i][6] && !board[i][7] && !board[i][8]) {
                    answer += 2;
                }else{
                    answer++;
                }
            } else if (!board[i][3] && !board[i][4] && !board[i][5] && !board[i][6]) {
                answer++;
            } else if (!board[i][5] && !board[i][6] && !board[i][7] && !board[i][8]) {
                answer++;
            }
        }

        return answer;
    }

    private int seatToIndex(char seat) {
        switch (seat) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            case 'G': return 6;
            case 'H': return 7;
            case 'J': return 8;
            case 'K': return 9;
            default:
                return -1;
        }
    }
}
