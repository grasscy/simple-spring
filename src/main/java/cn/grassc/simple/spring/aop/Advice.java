package cn.grassc.simple.spring.aop;

public interface Advice {
    Object invoke(Joinpoint joinpoint);
}
