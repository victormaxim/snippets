package A;

public class multiArfs {

    public static void main(String[] args) {

        multiArfs a = new multiArfs();
        a.testa("", "2", "3");
        a.testa("1", "2", "3");
        a.testa();
    }

    void testa(String... args){
        String dbGrep;
        dbGrep = args.length > 0 ? "a" : "b";
        //        if(args.length > 0) {
//            dbGrep = args[0].isEmpty() ? "a" : "b";
//        }
        System.out.println(dbGrep);
        System.out.println("x!");
//        System.out.println(args[2]);

    }

}
