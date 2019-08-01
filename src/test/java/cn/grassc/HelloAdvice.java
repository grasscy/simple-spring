package cn.grassc;

import cn.grassc.simple.spring.aop.Advice;
import cn.grassc.simple.spring.aop.Joinpoint;

public class HelloAdvice implements Advice {
    @Override
    public Object invoke(Joinpoint joinpoint) throws Throwable {
        System.out.println("before enter method...");
        return joinpoint.proceed();
    }
}
