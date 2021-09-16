package sandbox.drafts;

import org.apache.commons.lang.StringUtils;

public class StringzC {
    public static void main(String[] args) {
//        String s = "{{}){}(a()((}({{{}((abaacd";
//        String[] counts = s.split("\\{");
//        System.out.println(counts.length - 1);

//        String st = "abcabcabc";
//        String[] countz = st.split("abc");
//
//        System.out.println(countz.length - 1);

        String str = "abcdabc";
        String findStr = "abc";
        int lastIndex = 0;
        int count = 0;
        System.out.println(StringUtils.countMatches(str, findStr));

        System.out.println("->" + str.replaceAll(str, ""));

        String strip = str.replaceAll(findStr, "");

        

        System.out.println(strip);
        System.out.println(strip.indexOf(findStr));

        if(str.replaceAll(findStr, "").isEmpty()){
            System.out.println("yes");
            System.out.println(str.indexOf(str.replaceAll(findStr, "")));
        }
        else {
            System.out.println("no");
        }



    }
}

