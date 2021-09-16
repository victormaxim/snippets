package snippets.Stringz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alexandru.dima on 10/7/2016.
 */
public class specialString {

    public static void main(String[] args) {

        //String input = "string test  a is it";

        String input = "This is a test string";
        String[] inputs = {"aaaa", "abcbaba", "asasd", "mnonopoo"};

        System.out.println(args.length);

        for (String i : inputs) {
            int count = 0;
            System.out.println(i.length());
            for (int k = 0; k <= i.length(); k++) {
                for (int j = 1; j <= i.length() - k; j++) {
//                       System.out.println(k);
                    System.out.println(k + " " + j);
                    if (isPali(i.substring(k, k + j))) {
                        System.out.println(i.substring(k, k + j));
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
//        Scanner scan = new Scanner(System.in);
//        System.out.println("string: ");
//        input = scan.nextLine();

//        System.out.println(rev(input));
//        System.out.println(input.substring(0,3));
    }


    private static boolean isPali(String input){
        String reverse = "";

        String[] spart = input.split("");

        String revch ="";

        for (String x:spart) {
                revch = x + revch;
        }
        reverse = revch;
    return reverse.equals(input);
    }

}
