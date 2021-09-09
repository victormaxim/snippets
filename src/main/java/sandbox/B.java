package A;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class B {
    public void incr() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = A.class.getDeclaredMethod("test", String.class);
        Object rv = null;
        m.invoke(rv, "test");

    }
}
