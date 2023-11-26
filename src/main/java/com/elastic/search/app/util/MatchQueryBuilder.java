package com.elastic.search.app.util;


import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchQueryBuilder {

    public static Query buildMatchQuery(String field, String value){
        return Query.of(q->q.match(MatchQuery.of(m->m.field(field).query(value))));
    }

}
