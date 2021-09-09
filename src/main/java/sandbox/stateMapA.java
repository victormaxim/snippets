package A;

import java.util.HashMap;


public class stateMapA {

    private static Integer x;


    public static void main(String[] args) {
        HashMap<String, Integer> state_map = new HashMap<>();
        String[] statements = {"create", "read","create", "read","read","rename", "update"};
        System.out.println("x");
        state_map.put("Readx", 1);
        state_map.put("Ready", 2);
        state_map.put("Read2", 5);
        Integer count;
//        x = state_map.get("Read");
//        System.out.println(x);

        //        String test;
//        test = count == 0 ? "A" : "B";
//        System.out.println(test);


//        System.out.println("VAR: " + var);

//        count = state_map.getOrDefault("read", 0) == 0 ? 1 : state_map.get("read");
//        state_map.put("read", count);
//
//        count = state_map.getOrDefault(i, 0) == 0 ? 1 : state_map.get(i);
//        state_map.put(i, count);

        for (String i : statements) {
            System.out.println("i: " + i);
            System.out.println(state_map.getOrDefault(i,0));

            count = state_map.getOrDefault(i, 0) == 0 ? 1 : state_map.get(i) + 1;
            state_map.put(i, count);
        }

        for (HashMap.Entry<String, Integer> entry : state_map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }


    }

}
