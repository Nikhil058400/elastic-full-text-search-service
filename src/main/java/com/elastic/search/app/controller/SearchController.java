package com.elastic.search.app.controller;

import com.elastic.search.app.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    QueryService queryService;

    @GetMapping(value = "/searchByOrderNo")
    public Mono<Integer> termQuery(@RequestParam(value = "orderNo") final String orderNo){
        return queryService.getCount("orderNo",orderNo);
    }
}
