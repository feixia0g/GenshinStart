package com.example.genshinstart_backend.configuration.spring.mvc;

import com.example.genshinstart_backend.configuration.property.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @version 1.0.0
 * @description: The type Web mvc configuration.
 * @author feixia0g
 * @date 2024/7/10 9:20
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final SystemConfig systemConfig;

    /**
     * Instantiates a new Web mvc configuration.
     *
     * @param systemConfig            the system config
     */
    @Autowired
    public WebMvcConfiguration(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/student/index.html");
        registry.addRedirectViewController("/student", "/student/index.html");
        registry.addRedirectViewController("/admin", "/admin/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(31556926);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

}

