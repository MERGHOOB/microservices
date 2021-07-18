package com.margub.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "localhost:8000/") // comment out to use load balancing done by eureka
@FeignClient(name = "currency-exchange")  //remove url to use eureka load balancing
public interface CurrencyExchangeProxy {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to);
}
