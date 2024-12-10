package DFSBFS;

import java.io.*;
import java.util.*;

//백준 1759 암호 만들기
public class MakePassword {

    static int n, m;
    static Character[] arr;
    static int[] ch;
    static ArrayList<String> pws = new ArrayList<>();
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static boolean isValid(String pw) {
        int voCnt = 0;
        int moCnt = 0;
        for (Character c : pw.toCharArray()) {
            if (vowels.contains(c)) {
                voCnt++;
            }else{
                moCnt++;
            }
        }

        if (voCnt >= 1 && moCnt >= 2) {
            return true;
        }
        return false;
    }
    public static void solution1(int l, String pw) {
        if (l == n) {
            if (isValid(pw)) {
                pws.add(pw);
            }
        } else {
            for (int i = l; i < m; i++) {
                if (ch[i] == 0) {
                    if (pw.isEmpty()) {
                        ch[i] = 1;
                        solution1(l + 1, pw + arr[i]);
                        ch[i] = 0;
                    } else {
                        if (arr[i] > pw.charAt(pw.length() - 1)) {
                            ch[i] = 1;
                            solution1(l + 1, pw + arr[i]);
                            ch[i] = 0;
                        }
                    }
                }
            }
        }
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Character[m];
        ch = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        solution1(0, "");

        for (String t : pws) {
            bw.write(t);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
