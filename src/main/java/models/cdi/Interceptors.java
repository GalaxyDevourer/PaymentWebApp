package models.cdi;

import javax.annotation.PostConstruct;
import javax.interceptor.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding
@Target( { METHOD, TYPE } )
@Retention( RUNTIME )
@interface CustomInterceptor {}

@Interceptor
@CustomInterceptor
class NotesInterceptor {

    @PostConstruct
    private void postConst (InvocationContext invocationContext){
        System.out.println("Interceptor post const");
    }

    @AroundConstruct
    private void aroundConst (InvocationContext invocationContext){
        System.out.println("Interceptor around const");
    }

    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Interceptor around invoke");

        String target = context.getTarget().toString();
        String method = context.getMethod().getName();

        System.out.println("Target: " + target + " Method: " + method);

        return context.proceed();
    }
}