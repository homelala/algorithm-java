import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.next().toUpperCase();
        char input2 = Character.toUpperCase(in.next().charAt(0));
        int result = 0;

        for (int i =0 ; i < input1.length(); i++){
            if (input1.charAt(i) == input2){
                result++;
            }
        }
        System.out.println(result);
    }
}