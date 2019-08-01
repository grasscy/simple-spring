package cn.grassc.simple.spring.aop;

import java.lang.reflect.Method;
import java.util.List;

public class Joinpoint {
    private final Object target;

    private final Method method;

    private Object[] arguments;

    private List<Advice> chain;

    private int curAdviceIndex = -1;

    public Joinpoint(Object target, Method method, Object[] arguments, List<Advice> chain) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.chain = chain;

    }

    public Object proceed() throws Throwable {
        if (this.curAdviceIndex == this.chain.size() - 1) {
            return invokeJoinpoint();
        }
        Advice advice = this.chain.get(++this.curAdviceIndex);
        return advice.invoke(this);
    }

    public Object invokeJoinpoint() throws Throwable {
        this.method.setAccessible(true);
        return this.method.invoke(this.target, this.arguments);
    }
}
