package com.gyan.msdesign.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class CurrencyExchange {

    @Id
    @NonNull
    private Long id;
    @NonNull
    @Column(name="currency_from")
    private String from;
    @NonNull
    @Column(name="currency_to")
    private String to;
    @NonNull
    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;
    private String environment;
}
