package cn.grassc;

import cn.grassc.simple.spring.aop.ProxyFactory;
import cn.grassc.simple.spring.context.ApplicationContext;
import org.junit.Test;

public class Main {
    @Test
    public void ioc() throws Exception {
        ApplicationContext ctx = new ApplicationContext();
        ctx.register(HelloService.class);
        ctx.refresh();

        HelloService service = ctx.getBean(HelloService.class, "hello");
        service.doHello();
    }

    @Test
    public void aop() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new HelloService("Hello"));
        factory.setInterfaces(Hello.class);
        factory.addAdvice(new HelloAdvice());
        Hello hello = (Hello) factory.getProxy();
        hello.doHello();
    }


}
