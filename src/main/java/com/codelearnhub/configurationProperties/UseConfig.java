package com.codelearnhub.configurationProperties;

import com.codelearnhub.configurationProperties.before.ConfigRecord;
import com.codelearnhub.configurationProperties.record.Config;
import org.springframework.stereotype.Component;

@Component
public class UseConfig {

    private final Config config;

    public UseConfig(Config config) {
        this.config = config;
    }

}
