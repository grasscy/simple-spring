package cn.grassc.simple.spring.beans;

public interface BeanFactory {
    <T> T getBean(Class<T> tClass, Object... args) throws Throwable;
}
