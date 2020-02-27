package com.skyeagle.config;

import com.skyeagle.filter.anotherFilter;
import com.skyeagle.interceptor.LoginInterceptor;
import com.skyeagle.servlet.AnotherServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;


//等价与一个spring的xml配置文件,applicationContext.xml...
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathpatterns= {"/**"};
        String[] excludepatterns = {"/hello"};
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(pathpatterns)
                .excludePathPatterns(excludepatterns);
    }

    //等价xml中bean的配置
    //<bean id="方法名" class="方法返回类型"/>
    @Bean
    public ServletRegistrationBean AnotherServletRegisterationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new AnotherServlet(),
                "/anotherServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean AnotherFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new anotherFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
