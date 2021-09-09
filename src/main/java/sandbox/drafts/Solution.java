package sandbox.drafts;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        if (n <= 0) {
            System.out.println("Please enter a number above 0");
        } else if (n >= 200000) {
            System.out.println("Please enter a number below 200000");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }

            }

        }

    }
}

        public class Solution {
            public static void main(String[] args) throws IOException {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.fizzBuzz(n);

                bufferedReader.close();
            }
        }
