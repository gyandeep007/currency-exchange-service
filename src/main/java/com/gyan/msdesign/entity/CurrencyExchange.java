package com.gyan.msdesign.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal multipleConversion;
}
