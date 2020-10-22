package drafts.parents;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class B {

    public void incr(A y) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = A.class.getDeclaredMethod("test", String.class);
        Method n = A.class.getDeclaredMethod("test");

        n.invoke(y);
        m.invoke(y,"bla");

    }
}
