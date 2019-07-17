package cn.grassc.simple.spring.context;

import cn.grassc.simple.spring.beans.*;

public class ApplicationContext implements BeanDefinitionRegistry,BeanFactory {

    private final BeanDefinitionReader reader;

    private final BeanFactory beanFactory;

    public ApplicationContext() {
        this.reader = new BeanDefinitionReader(this);
        this.beanFactory = new DefaultBeanFactory();
    }

    public void register(Class<?> clazz) {
        this.reader.registerBean(clazz);
    }

    public <T> T getBean(Class<T> tClass,Object... args) throws Exception {
        return this.beanFactory.getBean(tClass,args);
    }

    public void refresh() {
    }

    @Override
    public void registerBeanDefinition(BeanDefinitionHolder holder, BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(holder, beanDefinition);
    }
}
