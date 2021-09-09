package snippets.threads;

import java.util.Deque;

import static java.lang.Thread.sleep;

public class threadStuff {


    static class test_thread extends Thread {
        int start_value;

        public void run() {
            try {
                for (int i = start_value; i <= (10 + start_value); i++) {
                    System.out.println(i);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static class MyRunnableImplementation implements Runnable {

        // We are creating anew class that implements the Runnable interface,
        // so we need to override and implement it's only method, run().
        @Override
        public void run() {

            // We are creating a simple loop which will run and allow us to take
            // a look into how the different threads run.
            for (int i = 0; i < 5; i++) {

                // Thread.currentThread().getName() is used to get the name of the
                // currently running thread. We can provide a name, if we create
                // the thread ourselves, else it will be given one from the JVM.
                System.out.println(Thread.currentThread().getName() +
                        "\twith Runnable: MyRunnableImplementation runs..." + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //int i = 5;
        //        System.out.println("UPDATE SET id = " + i * 10 + " WHERE id = " + i);

/**
        test_thread[] th = new test_thread[10];
        for (int i = 1; i < 10; i++) {
            th[i] = new test_thread();
            th[i].start_value = i * 10;
            th[i].start();
            sleep(1000);
        }
 **/

        MyRunnableImplementation r = new MyRunnableImplementation();
        Thread thread1 = new Thread(r, "Thread 1");
        thread1.start();

        // Create a thread and provide the Runnable argument as an anonymous inner class.
        // Since we are creating the class "on the spot", we need to provide the implementation
        // of the run() method here.
        // This way is faster and more compact, but it lacks reusability.
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                // We are doing the same thing as with the MyRunnableImplementation class
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() +
                            "\twith Runnable: Inner class Runnable runs..." + i);
                }
            }
        }, "Thread 3");
        thread3.start();

    }
}