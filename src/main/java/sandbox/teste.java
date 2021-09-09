package A;

public class teste {

    public static void main(String[] args) {
        teste T = new teste();
        T.stats();
        T.timeF();

    }


    public void tests(){
        String statement = "one";
        String[] words = statement.split("\\s+");
        System.out.println(words.length);

        if (words.length > 1 && words[1].equals("VIEW")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void stats(){
        long query = 6362278;
        long sync = 41644502;
        long checks = 589805611;
        long total = 31621445 * 22;

        System.out.println(((query *100)/total) + "%");
        System.out.println(((sync *100)/total) + "%");
        System.out.println(((checks *100)/total) + "%");


    }

    public void timeF(){
        long millis = 31621445;
//        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
//        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        long minutes = (millis / 1000)  / 60;
        long seconds = (int)((millis / 1000) % 60);
        long x;
        x = seconds * 1000 + minutes * 60000;
        System.out.println((millis - x));

        System.out.println(minutes + " : " + seconds);
    }


}
