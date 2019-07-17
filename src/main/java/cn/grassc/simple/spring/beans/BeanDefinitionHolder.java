package cn.grassc.simple.spring.beans;

public class BeanDefinitionHolder {
    private BeanDefinition beanDefinition;
    private String beanName;

    public BeanDefinitionHolder(BeanDefinition definition, String beanName) {
        this.beanDefinition = definition;
        this.beanName = beanName;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }

    public String getBeanName() {
        return beanName;
    }
}
