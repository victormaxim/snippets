package drafts.parents;

import java.lang.reflect.InvocationTargetException;

public class Parent {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = new A();
        B b = new B();
        a.test("x");
        b.incr(a);

    }

}
