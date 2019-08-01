package cn.grassc.simple.spring.beans;

public interface BeanFactory {
    void registerBeanDefinition(BeanDefinitionHolder holder, BeanDefinition beanDefinition);

    <T> T getBean(Class<T> tClass, Object... args) throws Throwable;
}
