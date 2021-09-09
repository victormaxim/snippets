package A;

import java.sql.Connection;
import java.util.Random;

public class runOveride implements Runnable {
    Connection conn;
    int repeat = 10;
    Random ran = new Random();
    public static String url;
    int x;
    long startMillis = System.currentTimeMillis();
    long nowMillis;
int y;

    public runOveride(int i) {
        x = i;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            // TODO: get start time. lookup in tests
            System.out.println(x);
//            Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
//            conn = DriverManager.getConnection(url, "dba", "");
//            conn.setAutoCommit(true);
//            Statement stmt = conn.createStatement();
//            stmt.clearBatch();
            System.out.println(x);
            // TODO: T2: 1000 / 10
            for (int i = 0; i < 1000; i++) {

//                stmt.addBatch("INSERT INTO table10000_int_autoinc ( col_int_key ) VALUES ( "+ ran.nextInt() + " );");
                if (i % 10 == 0){
                    System.out.println(i);
                }
//                long nowMillis = System.currentTimeMillis();
//                System.out.println( "===> " + (int)(nowMillis - this.startMillis));
//                    stmt.executeBatch();
                // get end  time. diff > 30 => break
            }

            do {
                nowMillis = System.currentTimeMillis();
                y = (int)(nowMillis - this.startMillis);
if(y % 10 == 0){ System.out.println( "===> " + y);}
            }
while ((int)(nowMillis - this.startMillis)<500);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //TODO: get seconds as parameter
//        runOveride.url = "jdbc:cubrid:localhost:" + args[0] + ":hatestdb:::";
        int nrOfThreads = Integer.parseInt(args[1]);
        int execTime = Integer.parseInt(args[2]);
        Thread[] ths = new Thread[nrOfThreads];
        for (int i = 0; i < nrOfThreads; i++) {
            ths[i] = new Thread(new runOveride(execTime));
            ths[i].start();
        }
    }
}
