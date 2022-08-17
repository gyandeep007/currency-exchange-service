package com.gyan.msdesign.controller;


import com.gyan.msdesign.entity.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from,
                                                     @PathVariable String to){
        CurrencyExchange currencyExchange = new CurrencyExchange(1L,
                from,to,new BigDecimal(100));
        return currencyExchange;
    }
}
