package com.feedback.knowledge.validation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan
public class MyWebConfig extends WebMvcConfigurationSupport {

    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
//        initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
//            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//            propertyEditorRegistry.registerCustomEditor(Date.class,
//                    new CustomDateEditor(dateFormatter, true));
//        });
        System.out.println("custom error proc: " + initializer.getBindingErrorProcessor());
        initializer.setBindingErrorProcessor(new CustomBindingErrorProcessor());
        return initializer;
    }
    
    
}
