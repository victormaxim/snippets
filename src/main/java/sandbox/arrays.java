package A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

public class arrays {
    HashMap<String, Long> instanceElapsedTimeByEnv = new HashMap<>();
    String envIdentify;

    public static void main(String[] args) throws InterruptedException {
        arrays a = new arrays();
        a.hashmaps();
    }



    public void hashmaps() throws InterruptedException {

        envIdentify = "instance1";
        instanceElapsedTimeByEnv.put(envIdentify, System.currentTimeMillis());
        sleep(100);
        instanceElapsedTimeByEnv.put(envIdentify, System.currentTimeMillis() - instanceElapsedTimeByEnv.get(envIdentify));

        envIdentify = "instance2";
        instanceElapsedTimeByEnv.put(envIdentify, System.currentTimeMillis());
        sleep(250);
        instanceElapsedTimeByEnv.put(envIdentify, System.currentTimeMillis() - instanceElapsedTimeByEnv.get(envIdentify));

        for (HashMap.Entry<String, Long> timers : instanceElapsedTimeByEnv.entrySet()) {
            System.out.println(timers.getKey() + ": " + timers.getValue());
        }
    }

        public void arraylists() throws InterruptedException {
            List<Long> list = new ArrayList<Long>();
            sleep(10);

            long taskStopTime = System.currentTimeMillis();
            list.add(taskStopTime);
            sleep(100);

            taskStopTime = System.currentTimeMillis();
            list.add(taskStopTime);

            System.out.println(list.get(0) + " - " + list.get(1));
            System.out.println(list.get(1)-list.get(0));

            for(int i = 0; i<list.size(); i++){
                System.out.println(list.get(i));

            }
        }


    }
