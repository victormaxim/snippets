package A;

public class testPrint {


    static class test_thread extends Thread {
        int start_value;

        public void run() {

            try{
                for (int i=start_value; i<=(10+start_value); i++) {
                    System.out.println(i);
                }

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
//int i = 5;

//        System.out.println("UPDATE SET id = " + i * 10 + " WHERE id = " + i);
        test_thread[] th = new test_thread[10];
        for(int i = 1; i < 10; i++){
            th[i] = new test_thread();
            th[i].start_value = i * 10;
            th[i].start();
        }
//
//        for(int j=1; j<=100;j++){
//            System.out.println(j);
//        }
//
//        for(int j=1; j<5;j++){
//            System.out.println(j);
//        }

    }
}
