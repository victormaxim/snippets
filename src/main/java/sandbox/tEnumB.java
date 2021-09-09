package A;

public class tEnumB {

    public enum Stuff {
        GT("greater than"),
        SAVE_BUTTON("");

        String value;
        Stuff(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        System.out.println(Stuff.valueOf("GT").getValue());

        for (Stuff element : Stuff.values()) {
            System.out.println(element);
        }
        Stuff s = Stuff.GT;
        System.out.println(s.getValue());

    }

}
