package com.elastic.search.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @JsonProperty("order_no")
    private String orderNo;

    @JsonProperty("order_header_key")
    private String orderHeaderKey;
}
