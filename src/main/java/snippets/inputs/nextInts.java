package snippets.inputs;

import java.util.LinkedList;
import java.util.Scanner;

public class nextInts {
    static LinkedList<Integer> lista = new LinkedList<>();
    static int suma;
    static int myint;
    static Scanner keyboard;

    public static void main(String[] args) {

        keyboard = new Scanner(System.in);

//        for(int i =0; i<10; i++){
//            System.out.println(keyboard.hasNext());
//        }
        keyboard.close();
        String x = keyboard.toString();
//        x.
        while(keyboard.hasNextInt()) {
//            System.out.println(keyboard.hasNextLine());

            System.out.println(keyboard.nextInt());

        }


        keyboard.close();
        myint = keyboard.nextInt();


    }
}
