package string;
import java.util.Scanner;

public class FindString {
    public int solution(String str, char c){
        int result = 0;
        for (int i =0 ; i < str.length(); i++){
            if (str.charAt(i) == c){
                result++;
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String input1 = in.next().toUpperCase();
        char input2 = Character.toUpperCase(in.next().charAt(0));
        System.out.println(solution(input1, input2));
    }
}
