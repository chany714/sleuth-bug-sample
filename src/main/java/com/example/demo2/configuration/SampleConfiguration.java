package com.example.demo2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@VaultPropertySource("my/clients/local")
public class SampleConfiguration {
    private final Environment environment;

    public SampleConfiguration(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public TestBean getData() {
        TestBean testBean = new TestBean();
        testBean.setSecret(environment.getProperty("user.name"));

        return testBean;
    }

}
