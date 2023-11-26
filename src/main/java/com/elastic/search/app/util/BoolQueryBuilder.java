package com.elastic.search.app.util;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BoolQueryBuilder {

    private final List<Query> must;
    private final List<Query> filter;
    private final List<Query> should;
    private final List<Query> mustNot;

    public BoolQueryBuilder(Builder builder){
        this.must = Objects.nonNull(builder.must) ? Collections.unmodifiableList(builder.must) : Collections.emptyList();
        this.filter = Objects.nonNull(builder.filter) ? Collections.unmodifiableList(builder.filter) : Collections.emptyList();
        this.should = Objects.nonNull(builder.should) ? Collections.unmodifiableList(builder.should) : Collections.emptyList();
        this.mustNot = Objects.nonNull(builder.mustNot) ? Collections.unmodifiableList(builder.mustNot) : Collections.emptyList();
    }

    public static Query buildBoolQuery(BoolQueryBuilder builder){
        return Query.of(q->q.bool(b->b.must(builder.must).filter(builder.filter).should(builder.should).mustNot(builder.mustNot)));
    }

    public static class Builder{
        private List<Query> must;
        private List<Query> filter;
        private List<Query> should;
        private List<Query> mustNot;

        public Builder(){
        }

        public Builder must(Query query){
            this.must = addQuery(this.must,query);
            return this;
        }

        public Builder filter(Query query){
            this.filter = addQuery(this.filter,query);
            return this;
        }

        public Builder should(Query query){
            this.should = addQuery(this.should,query);
            return this;
        }

        public Builder mustNot(Query query){
            this.mustNot = addQuery(this.mustNot,query);
            return this;
        }

        public BoolQueryBuilder build(){
            return new BoolQueryBuilder(this);
        }

        private List<Query> addQuery(List<Query> list,Query query){
            if (Objects.nonNull(list)){
                list.add(query);
                return list;
            }
            return List.of(query);
        }


    }

}
