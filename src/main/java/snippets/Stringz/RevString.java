package snippets.Stringz;

import java.util.Scanner;

/**
 * Created by alexandru.dima on 10/7/2016.
 */
public class RevString {

    public static void main(String[] args) {

        //String input = "string test  a is it";

        String input = "This is a test string";
        Scanner scan = new Scanner(System.in);
        System.out.println("string: ");
        input = scan.nextLine();

//        System.out.println(rev(input));

        System.out.println(rev(input).equals(input) ? "Yes" : "NO");
    }

    private static String rev(String input){
        String reverse = "";

        String[] spart = input.split("");
        String revch ="";

        for (String x:spart) {
                revch = x + revch;
        }
        reverse = revch;
        return reverse;
    }

}
