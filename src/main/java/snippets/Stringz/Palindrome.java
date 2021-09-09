package snippets.Stringz;

import java.util.Scanner;

/**
 * Created by alexandru.dima on 10/7/2016.
 */
public class Palindrome {

    public static void main(String[] args) {

        //String input = "string test  a is it";

        String input = "This is a test string";
        Scanner scan = new Scanner(System.in);
        System.out.println("string: ");
        input = scan.nextLine();

        System.out.println(rev(input));

    }

    private static String rev(String input){
        String reverse = "";

        String[] spart = input.split("");
//        System.out.println(spart);
//        char[] ch;
        String revch ="";
//        revch ="";

        for (String x:spart) {
//            System.out.println(x);

//        System.out.println("de intors: " + x + " " + x.charAt(0) + " " + x.length());
//        ch = x.toCharArray();
//            System.out.println(ch);


//                System.out.println(cha);
                revch = x + revch;

        }
        reverse = revch;
    return reverse;
    }

}
