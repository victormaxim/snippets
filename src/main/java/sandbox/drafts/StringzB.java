package sandbox.drafts;

import org.apache.commons.lang.StringUtils;

public class StringzB {
    public static void main(String[] args) {
        String s = "{{}){}(a()((}({{{}((abaacd";
        String[] counts = s.split("\\{");
        System.out.println(counts.length - 1);

//        String st = "abcabcabc";
//        String[] countz = st.split("abc");
//
//        System.out.println(countz.length - 1);

        String str = "heyheyoslkheyodjladfjhey";
        String findStr = "hey";
        int lastIndex = 0;
        int count = 0;
        System.out.println(StringUtils.countMatches(str, findStr));
        System.out.println(str.replaceAll(findStr, ""));



    }
}

