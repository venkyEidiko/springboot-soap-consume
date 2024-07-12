package com.eidiko.consume_soap_api.controller;




import com.eidiko.consume_soap_api.client.TemperatureConverterClient;
import com.eidiko.consume_soap_api.tempconverter.CelsiusToFahrenheit;
import com.eidiko.consume_soap_api.tempconverter.CelsiusToFahrenheitResponse;
import com.eidiko.consume_soap_api.tempconverter.FahrenheitToCelsius;
import com.eidiko.consume_soap_api.tempconverter.FahrenheitToCelsiusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemperatureController {

    @Autowired
    private TemperatureConverterClient client;

    @GetMapping("/fahrenheitToCelsius")
    public FahrenheitToCelsiusResponse fahrenheitToCelsius(@RequestBody FahrenheitToCelsius fahrenheitToCelsius) {
        return client.fahrenheitToCelsius(fahrenheitToCelsius.getFahrenheit());
    }

    @GetMapping("/celsiusToFahrenheit")
    public CelsiusToFahrenheitResponse celsiusToFahrenheit(@RequestBody CelsiusToFahrenheit celsiusToFahrenheit) {
        return client.celsiusToFahrenheit(celsiusToFahrenheit.getCelsius());
    }
}
