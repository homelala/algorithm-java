package DFSBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 14889 스타트와 링크
public class StartAndLink {

    static int[][] arr;
    static int n;
    static int answer = Integer.MAX_VALUE;
    public static ArrayList<Integer> startTeam = new ArrayList<>(), LinkTeam;


    public static void getTeam(int l) {
        if (startTeam.size() == n/2) {
            answer = Math.min(answer, checkAbility(startTeam));
        }else{
            for (int i = l; i <= n; i++) {
                startTeam.add(i);
                getTeam(i + 1);
                startTeam.remove(Integer.valueOf(i));
            }
        }
    }

    public static ArrayList<Integer> getLinkTeam(ArrayList<Integer> startTeam) {
        ArrayList<Integer> team = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!startTeam.contains(i)) {
                team.add(i);
            }
        }
        return team;
    }

    public static int checkAbility(ArrayList<Integer> startTeam) {
        LinkTeam = getLinkTeam(startTeam);
        int startTeamAbility = 0, LinkTeamAbility = 0;
        for (int i = 0; i < startTeam.size(); i++) {
            int first = startTeam.get(i);
            for (int j = 0; j < startTeam.size(); j++) {
                if (i == j) {
                    continue;
                }
                int second = startTeam.get(j);
                startTeamAbility += arr[first][second];
            }
        }
        for (int i = 0; i < LinkTeam.size(); i++) {
            int first = LinkTeam.get(i);
            for (int j = 0; j < LinkTeam.size(); j++) {
                if (i == j) {
                    continue;
                }
                int second = LinkTeam.get(j);
                LinkTeamAbility += arr[first][second];
            }
        }
        return Math.abs(startTeamAbility - LinkTeamAbility);
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getTeam(1);
        bw.write(answer + "");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
