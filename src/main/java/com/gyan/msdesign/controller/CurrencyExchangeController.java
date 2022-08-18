package com.gyan.msdesign.controller;


import com.gyan.msdesign.entity.CurrencyExchange;
import com.gyan.msdesign.repository.CurrencyExchangeRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {


    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepo repo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from,
                                                     @PathVariable String to){
//        CurrencyExchange currencyExchange = new CurrencyExchange(1L,
//                from,to,new BigDecimal(100));
        System.out.println("request received for "+from+" and "+to);
        CurrencyExchange currencyExchange = repo.findByFromAndTo(from,to);
        if(currencyExchange == null)
            throw new RuntimeException("Unable to find data for "+from+" to "+to);
        currencyExchange.setEnvironment(env.getProperty("local.server.port"));

        System.out.println("returning currency exchange value "+currencyExchange.getConversionMultiple());

        return currencyExchange;
    }
}
