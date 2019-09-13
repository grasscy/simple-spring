package cn.grassc.simple.spring.context;

import cn.grassc.simple.spring.beans.GenericApplicationContext;

public class ApplicationContext extends GenericApplicationContext {

    private final BeanDefinitionReader reader;

    public ApplicationContext() {
        this.reader = new BeanDefinitionReader(this);
    }

    public void register(Class<?> clazz) {
        this.reader.registerBean(clazz);
    }

    public void refresh() {
    }

}
