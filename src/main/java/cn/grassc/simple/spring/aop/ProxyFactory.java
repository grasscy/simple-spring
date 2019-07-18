package cn.grassc.simple.spring.aop;

import java.util.ArrayList;
import java.util.List;

public class ProxyFactory {
    private TargetSource targetSource;
    private List<Class<?>> interfaces = new ArrayList<>();
    private List<Advisor> advisors = new ArrayList<>();

    public void setTarget(Object target) {
        this.targetSource = new TargetSource(target);
    }

    public void setInterfaces(Class<?> interfaces) {
        if (interfaces.isInterface()) {
            this.interfaces.add(interfaces);
        }
    }

    public void addAdvice(Advice advice) {
        this.advisors.add(new Advisor(new Pointcut(), advice));
    }

    public Object getProxy() {

    }
}
