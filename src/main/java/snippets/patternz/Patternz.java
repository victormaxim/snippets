package snippets.patternz;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Patternz {

    static String regex;
    static String line;

    public static void main(String[] args) {

       line = "1 fish 2 fish red fish blue fish";

        regex = "(\\d+) fish (\\d+) fish (\\w+) fish (\\w+) fish";

        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "\\..\\" + "snippets\\src\\test\\resources\\" + "regexMatches.txt"))) {
            stream.forEach(linez -> {
                    matchMatcher(linez);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        line = "1 fish 2 fish red fish blue fish";
        regex = "(\\\\d+) fish (\\\\d+) fish (\\\\w+) fish (\\\\w+) fish\"";
        matchMatcherB(line, regex);
    }

    public void groupRepeat(){
        Pattern p = Pattern.compile("((.)\\2*)");
        Matcher m = p.matcher("qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT");
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }

    public static void matchMatcherB(String line, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        System.out.println(line);
        System.out.println(regex);
        if (matcher.find()) {
            System.out.println("occ: " + matcher.groupCount());
        }

//        for (int i = 0; i <= matcher.groupCount(); i++) {
//            System.out.println(matcher.group(i));
//        }
    }


    public static void matchMatcher(String line){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
        }

        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
    }

}



