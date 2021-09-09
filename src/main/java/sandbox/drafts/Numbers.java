package sandbox.drafts;

public class Numbers {
    public static void main(String[] args) {
        try{
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte b = f1.byteValue();
            double d = f1.doubleValue();
            System.out.println(x + b + d);
            System.out.println(b);
            System.out.println(d);

            int mask = 0x000F;
            int value = 0x2222;
            System.out.println(value & mask);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
