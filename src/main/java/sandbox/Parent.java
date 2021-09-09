package A;

import java.lang.reflect.InvocationTargetException;

public class Parent {



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = new A();
        B b = new B();
        b.incr();
        a.test("x");

    }

}
