package sandbox.drafts;

import java.io.*;
import java.util.*;


public class bracketsC {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        ParserB parser = new ParserB();
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            System.out.println(parser.isBalanced(in.next()));
//        }
//        in.close();


        ParserC parserc = new ParserC();
        parserc.counter();
    }

}

class ParserC{
    public static void counter(){
        String x = "{{}){}(a()((}({{{}((abaacd";
        HashMap<String, String> map = new HashMap<String, String>();

//        String[] counts = s.split("()");

        map.put("\\(","\\)");
        map.put("a","b");

        for (HashMap.Entry<String, String> item : map.entrySet()) {

            String[] countsO = x.split(item.getKey());
            String[] countsC = x.split(item.getValue());

            System.out.println(countsO.length - 1);
            System.out.println(countsC.length - 1);

//            System.out.println(item.getKey() + ": " + item.getValue());
        }



    }
}

class ParserB {
    public static boolean isBalanced(String s) {

        if (s == null || s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty()) {
                    char latestOpenP = stack.pop();
                    if (latestOpenP == '(' && c != ')') {
                        return false;
                    } else if (latestOpenP == '{' && c != '}') {
                        return false;
                    } else if (latestOpenP == '[' && c != ']') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

