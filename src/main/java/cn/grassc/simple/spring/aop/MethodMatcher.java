package cn.grassc.simple.spring.aop;

import java.lang.reflect.Method;

public class MethodMatcher {
    public static final MethodMatcher TRUE = new MethodMatcher();

    public boolean matches(Method method, Class<?> targetClass) {
        return true;
    }
}
