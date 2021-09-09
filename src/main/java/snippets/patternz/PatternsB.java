package snippets.patternz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsB {
    public static void main(String[] args) {

        Pattern EMAIL_ADDRESS_PATTERN =
                Pattern.compile("(grup)");

        String OVERLAPPING_EMAIL_ADDRESSES = "grupgrupgrup";
//        String OVERLAPPING_EMAIL_ADDRESSES = "Try to grup us grup at team@baeldung.comeditor@baeldung.com, support@baeldung.com.";

        Matcher countOverlappingEmailsMatcher = EMAIL_ADDRESS_PATTERN.matcher(OVERLAPPING_EMAIL_ADDRESSES);

        int count = 0;
        while (countOverlappingEmailsMatcher.find()) {
            count++;
        }
        if(countOverlappingEmailsMatcher.matches()) {
            System.out.println("x");
        }

        System.out.println(count);
//        assertEquals(2, count);

    }
}
