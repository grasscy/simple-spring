package cn.grassc.simple.spring.aop;


public class Pointcut {
    public static final Pointcut TRUE = new Pointcut();

    public MethodMatcher getMethodMatcher() {
        return MethodMatcher.TRUE;
    }
}
