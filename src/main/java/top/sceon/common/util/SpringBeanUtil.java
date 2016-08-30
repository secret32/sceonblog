package top.sceon.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class SpringBeanUtil implements ApplicationContextAware {

    protected static ApplicationContext context = null;

    public void setApplicationContext(ApplicationContext arg0) {
        SpringBeanUtil.context = arg0;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }

}
