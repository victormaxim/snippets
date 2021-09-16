package sandbox.drafts;


import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultsB {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String string, String sub, long n) {


        long size = string.length();

        long repeated = n / size;

        long left = n - (size * repeated);

int j = (int) left;


        System.out.println("repeated: " + repeated);
        System.out.println("left: " + left);
        System.out.println("size: " + size);
        System.out.println("leftsize: " + j);

//        long left = n - (size * repeated);
        int extra = 0;
        System.out.println(repeated);

        int repeatsInLoop = StringUtils.countMatches(string, sub)  * (int) repeated;
        int repeatsInLeft = StringUtils.countMatches(string.substring(0, (int)left), sub);
        System.out.println("RLoop: " + repeatsInLoop);
        System.out.println("Rlft: " + repeatsInLeft);

//        int count = 0;
//        for(int i = 0; i < size; i++){
//            if(s.charAt(i) == 'a'){
//                ++count;
//            }
//        }
//
//        for(int i = 0; i < left; i++){
//            if(s.charAt(i) == 'a'){
//                ++extra;
//            }
//        }

//        repeated = (repeated * count) + extra;

        return repeated;

    }

}

public class repeatedStringsB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String string = bufferedReader.readLine();
        String sub = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = ResultsB.repeatedString(string, sub, n);
        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

