package com.example.genshinstart_backend;

import com.example.genshinstart_backend.configuration.property.SystemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @version 3.5.0
 * @description: The type genshinstart application.
 * @author feixia0g
 * @date 2024/7/10 10:50
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(value = { SystemConfig.class})
public class GenshinStartBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinStartBackendApplication.class, args);
    }

}
