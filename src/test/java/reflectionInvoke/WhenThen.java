package reflectionInvoke;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface WhenThen {

    public String value() default "default";
}
