package cn.grassc.simple.spring.beans;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class GenericApplicationContext implements BeanFactory, BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(BeanDefinitionHolder holder, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(holder.getBeanName(), beanDefinition);
    }

    @Override
    public <T> T getBean(Class<T> tClass, Object... args) throws Exception {
        String beanName = tClass.getName();
        return createBean(this.beanDefinitionMap.get(beanName), args);
    }

    private <T> T createBean(BeanDefinition beanDefinition, Object... args) throws Exception {
        Class clazz = beanDefinition.getBeanClass();
        List<Class> argsClazz = Arrays.stream(args).map(Object::getClass).collect(Collectors.toList());
        Constructor constructor = clazz.getDeclaredConstructor(argsClazz.toArray(new Class[]{}));
        constructor.setAccessible(true);
        Object instance = constructor.newInstance(args);

        return (T) instance;
    }

}
