package sandbox.drafts;

public class StringzB {
    public static void main(String[] args) {
        String s = "{{}){}(a()((}({{{}((abaacd";
        String[] counts = s.split("\\{");
        System.out.println(counts.length - 1);



    }
}

