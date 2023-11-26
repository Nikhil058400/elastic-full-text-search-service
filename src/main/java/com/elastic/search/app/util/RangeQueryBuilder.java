package com.elastic.search.app.util;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.json.JsonData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RangeQueryBuilder {

    public static Query buildRangeQuery(String field, Integer lt, Integer gt){
        return Query.of(q->q.range(RangeQuery.of(r->r.field(field).lt(JsonData.of(lt)).gt(JsonData.of(gt)))));
    }
}
