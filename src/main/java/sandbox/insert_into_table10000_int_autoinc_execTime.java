package A;

import java.sql.Connection;
import java.util.Random;

public class insert_into_table10000_int_autoinc_execTime implements Runnable {
    Connection conn;
    Random ran = new Random();
    public static String url;
    int execTime;
    long startMillis;
    long nowMillis;

    public insert_into_table10000_int_autoinc_execTime(int seconds) {
        execTime = seconds;
    }

    @Override
    public void run() {
        try {
            startMillis = System.currentTimeMillis();
//            Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
//            conn = DriverManager.getConnection(url, "dba", "");
//            conn.setAutoCommit(true);
//            Statement stmt = conn.createStatement();
//            stmt.clearBatch();


            for (int i = 0; i < 1000; i++) {
//                stmt.addBatch("INSERT INTO table10000_int_autoinc ( col_int_key ) VALUES ( " + ran.nextInt() + " );");
//                if (i % 10 == 0){stmt.executeBatch();}
            Thread.sleep(1000);
                System.out.println((int)((nowMillis - startMillis)/1000));
                nowMillis = System.currentTimeMillis();
                if((int)((nowMillis - startMillis)/1000) >= execTime ) return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insert_into_table10000_int_autoinc_execTime.url = "jdbc:cubrid:localhost:" + args[0] + ":hatestdb:::";
        int nrOfThreads = Integer.parseInt(args[1]);
        int execTime = Integer.parseInt(args[2]);
        Thread[] ths = new Thread[nrOfThreads];
        for (int i = 0; i < nrOfThreads; i++) {
            ths[i] = new Thread(new insert_into_table10000_int_autoinc_execTime(execTime));
            ths[i].start();
        }
    }
}
