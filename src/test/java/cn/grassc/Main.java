package cn.grassc;

import cn.grassc.simple.spring.context.ApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ApplicationContext();
        ctx.register(HelloService.class);
        ctx.refresh();

        HelloService service = ctx.getBean(HelloService.class, "Hello");
        service.doHello();
    }
}
