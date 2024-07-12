package com.eidiko.consume_soap_api.client;



import com.eidiko.consume_soap_api.tempconverter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class TemperatureConverterClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public FahrenheitToCelsiusResponse fahrenheitToCelsius(String fahrenheit) {
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        fahrenheitToCelsius.setFahrenheit(fahrenheit);
        WebServiceTemplate template = new WebServiceTemplate(marshaller);

        return (FahrenheitToCelsiusResponse) template
                .marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx?WSDL",
                        fahrenheitToCelsius,
                        new SoapActionCallback("https://www.w3schools.com/xml/FahrenheitToCelsius"));

    }

    public CelsiusToFahrenheitResponse celsiusToFahrenheit(String celsius) {

        CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheit();
        celsiusToFahrenheit.setCelsius(celsius);

        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        return (CelsiusToFahrenheitResponse)template.marshalSendAndReceive
                ("https://www.w3schools.com/xml/tempconvert.asmx?WSDL",celsiusToFahrenheit,
                new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));

    }
}
