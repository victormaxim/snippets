package sandbox.drafts;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

class ResultB {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {


            String str = "hackerrank";
            if (s.length() < str.length()) {
                return "NO";
            }
            int j = 0;

            for (int i = 0; i < s.length(); i++) {
                if (j < str.length() && s.charAt(i) == str.charAt(j)) {
                    j++;
                }
            }
            return (j == str.length() ? "YES" : "NO");

        }


    }



public class hkrnkString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            String result = ResultB.hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
