package cn.grassc.simple.spring.beans;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(BeanDefinitionHolder holder, BeanDefinition beanDefinition);
}
