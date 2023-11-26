package com.elastic.search.app.service;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.elastic.search.app.entities.Order;
import com.elastic.search.app.util.BoolQueryBuilder;
import com.elastic.search.app.util.TermsQueryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class QueryService {

    private final ReactiveElasticsearchClient reactiveElasticsearchClient;

    public QueryService(ReactiveElasticsearchClient reactiveElasticsearchClient) {
        this.reactiveElasticsearchClient = reactiveElasticsearchClient;
    }

    public Mono<Integer> getCount(final String field, final String value){
        BoolQueryBuilder boolQuery = new BoolQueryBuilder.Builder().must(TermsQueryBuilder.buildTermQuery(field,value)).build();
        log.info(BoolQueryBuilder.buildBoolQuery(boolQuery).toString());
        return reactiveElasticsearchClient.search(new SearchRequest.Builder().
                query(BoolQueryBuilder.buildBoolQuery(boolQuery)).build(), Order.class)
                .flatMap(responseBody -> Mono.just(responseBody.hits().hits().size()));
    }
}
