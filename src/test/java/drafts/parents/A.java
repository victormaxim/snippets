package drafts.parents;

import java.lang.reflect.InvocationTargetException;

public class A {
    String str;

    public A() {

    }

    public void test(String x) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.str = x;
        System.out.println(x);
    }

    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("set string: " + str);
    }


}
