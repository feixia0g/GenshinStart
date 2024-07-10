package com.example.genshinstart_backend;

import com.example.genshinstart_backend.configuration.property.SystemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = { SystemConfig.class})
public class GenshinStartBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinStartBackendApplication.class, args);
    }

}
