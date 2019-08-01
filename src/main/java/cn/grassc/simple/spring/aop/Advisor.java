package cn.grassc.simple.spring.aop;

public class Advisor {
    private Pointcut pointcut;
    private Advice advice;

    public Advisor(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }
}
