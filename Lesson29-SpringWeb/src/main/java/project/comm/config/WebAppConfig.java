package project.comm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import project.comm.userService.PostConverter;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Autowired
    private MyIntercepter myIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(myIntercepter);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PostConverter());
    }
}
