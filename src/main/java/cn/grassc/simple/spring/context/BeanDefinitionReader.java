package cn.grassc.simple.spring.context;

import cn.grassc.simple.spring.beans.BeanDefinition;
import cn.grassc.simple.spring.beans.BeanDefinitionHolder;
import cn.grassc.simple.spring.beans.BeanDefinitionRegistry;

public class BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    public BeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void registerBean(Class<?> clazz) {
        BeanDefinition definition = new BeanDefinition(clazz);
        String beanName = definition.getBeanClass().getName();
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(definition, beanName);
        registerBeanDefinition(definitionHolder, this.registry);
    }

    public void registerBeanDefinition(BeanDefinitionHolder holder, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition(holder, holder.getBeanDefinition());
    }
}
