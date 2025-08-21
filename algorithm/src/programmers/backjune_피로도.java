package programmers;

public class backjune_피로도 {
    static boolean[] visited;
    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
//        getRoot(dungeons, 0, new int[dungeons.length], k);
        getRoot1(dungeons, 0, k);
        return answer;
    }

    private static void getRoot(int[][] dungeons, int count, int[] root, int k) {
        if (count == dungeons.length) {
            int c = 0;
            for (int i : root) {
                if (k >= dungeons[i][0]) {
                    k -= dungeons[i][1];
                    c++;
                }
            }
            answer = Math.max(answer, c);
        }else{
            for (int i = 0; i < dungeons.length; i++) {
                if(visited[i]) continue;
                root[count] = i;
                visited[i] = true;
                getRoot(dungeons, count + 1, root, k);
                visited[i] = false;
            }
        }
    }

    private static void getRoot1(int[][] dungeons, int count, int k) {
        if (k < 0) {
            return;
        } else {
            answer = Math.max(answer, count);
        }

        for (int i = 0; i < dungeons.length; i++) {
            if(visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            k -= dungeons[i][1];
            getRoot1(dungeons, count + 1, k);
            visited[i] = false;
            k += dungeons[i][1];
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
