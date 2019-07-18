package cn.grassc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HelloInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.printf("before %s...\n", invocation);
        Object proceed = invocation.proceed();
        System.out.printf("after %s...\n", invocation);
        return proceed;
    }
}
