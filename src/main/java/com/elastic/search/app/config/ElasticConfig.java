package com.elastic.search.app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

@Configuration
@Slf4j
@EnableReactiveElasticsearchRepositories
public class ElasticConfig extends ReactiveElasticsearchConfiguration {

    private final ElasticProperties elasticProperties;

    public ElasticConfig(ElasticProperties elasticProperties) {
        this.elasticProperties = elasticProperties;
    }

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder().connectedTo(elasticProperties.getUris())
                .withBasicAuth(elasticProperties.getUsername(),elasticProperties.getPassword()).build();
    }
}
