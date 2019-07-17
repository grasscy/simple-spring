package cn.grassc.simple.spring.beans;

public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
