package com.elastic.search.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "elasticsearch")
@Data
@Component
public class ElasticProperties {
    private String uris;
    private String username;
    private String password;
}
