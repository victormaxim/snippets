package A;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kanahaiya Gupta
 *
 */
public class Stringz {
    public static void main(String[] args) {

        String str = "helloslkhellohellodjladfjhello";
        Pattern p = Pattern.compile("hello");
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()){
            count +=1;
        }
        System.out.println(count);

        Scanner sc = new Scanner(System.in);
        str = sc.next();
        String sub = sc.next();
        sc.close();

        String[] parts = str.split(sub);
        System.out.println(parts.length);

        for(String piece: parts)
        {
            System.out.println(piece);
            if(piece.isEmpty()){
                System.out.println("X!");
            }
        }
//        String part1 = parts[0]; // 004
//        String part2 = parts[1]; // 034556

    }
}