package drafts.misc;

import org.apache.commons.lang.time.DurationFormatUtils;

public class teste {
    long minutes;
    long seconds;

    public static void main(String[] args) {
        teste T = new teste();
        T.stats();
//        T.timeF();

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
        long query = 3000;
        long sync = 41644502;
        long checks = 589805611;
        long total = 455146;



//        minutes = (query / 1000)  / 60;
//        seconds = (int)((query / 1000) % 60);

//        String x = DurationFormatUtils.formatDuration(query, "H:mm:ss", true);
////        int minutes = time / (60 * 1000);
////        int seconds = (time / 1000) % 60;
//        String str = String.format("%dmin %02dsec", minutes, seconds);
//        System.out.println(str);
//        System.out.println(x);
//        System.out.println((minutes > 0 ? minutes + "min " : "x") + seconds + "s " + Math.round(((double)query * 100) / total) + "%");
//        System.out.println(((sync *100)/total) + "%");
//        System.out.println(((checks *100)/total) + "%");
        System.out.println(convertMillis(total));
        System.out.println(convertMillis(query));

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

    public String convertMillis(long millis){
        minutes = (millis / 1000) / 60;
        seconds = (int)((millis / 1000) % 60);
        return (minutes > 0 ? minutes + "m " : "") + seconds + "s";
    }

}
