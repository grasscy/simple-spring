package cn.grassc;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class hh {
    @Test
    public void aopring() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new HelloService("Hello"));
        factory.setInterfaces(Hello.class);
        factory.addAdvice(new HelloInterceptor());
        Hello hello = (Hello) factory.getProxy();
        hello.doHello();
    }
}
