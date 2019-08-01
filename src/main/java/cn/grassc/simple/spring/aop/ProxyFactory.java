package cn.grassc.simple.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory implements InvocationHandler {
    private Object target;
    private List<Class<?>> interfaces = new ArrayList<>();
    private List<Advisor> advisors = new ArrayList<>();

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setInterfaces(Class<?> interfaces) {
        if (interfaces.isInterface()) {
            this.interfaces.add(interfaces);
        }
    }

    public void addAdvice(Advice advice) {
        this.advisors.add(new Advisor(Pointcut.TRUE, advice));
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.interfaces.toArray(new Class[]{})
                , this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Advice> chain = new ArrayList<>();
        for (Advisor advisor : this.advisors) {
            MethodMatcher methodMatcher = advisor.getPointcut().getMethodMatcher();
            if (methodMatcher.matches(method, this.target.getClass())) {
                chain.add(advisor.getAdvice());
            }
        }
        Joinpoint joinpoint = new Joinpoint(target, method, args, chain);
        return joinpoint.proceed();
    }
}
