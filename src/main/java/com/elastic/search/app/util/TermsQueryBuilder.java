package com.elastic.search.app.util;

import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TermsQueryBuilder {

    public static Query buildTermQuery(String field, String value){
        return Query.of(q->q.term(TermQuery.of(t->t.field(field).value(value))));
    }

    public static Query buildTermQuery(String field, Integer value){
        return Query.of(q->q.term(TermQuery.of(t->t.field(field).value(value))));
    }

    public static Query buildTermQuery(String field, Long value){
        return Query.of(q->q.term(TermQuery.of(t->t.field(field).value(value))));
    }

    public static Query buildTermQuery(String field, Boolean value){
        return Query.of(q->q.term(TermQuery.of(t->t.field(field).value(value))));
    }

    public static Query buildTermsQuery(String field, Integer... values){
        List<Integer> list = Arrays.asList(values);
        return Query.of(q->q.terms(TermsQuery.of(ts->ts.field(field).terms(t->t.value(list.stream().flatMap(val-> Stream.of(FieldValue.of(val))).toList())))));
    }

    public static Query buildTermsQuery(String field, String... values){
        List<String> list = Arrays.asList(values);
        return Query.of(q->q.terms(TermsQuery.of(ts->ts.field(field).terms(t->t.value(list.stream().flatMap(val-> Stream.of(FieldValue.of(val))).toList())))));
    }

    public static Query buildTermsQuery(String field, Long... values){
        List<Long> list = Arrays.asList(values);
        return Query.of(q->q.terms(TermsQuery.of(ts->ts.field(field).terms(t->t.value(list.stream().flatMap(val-> Stream.of(FieldValue.of(val))).toList())))));
    }

}
