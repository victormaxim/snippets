package sandbox.drafts;

import java.io.*;
import java.util.*;


public class brackets {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }
        in.close();

    }

}

class Parser {
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

