package com.eidiko.consume_soap_api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.eidiko.consume_soap_api.tempconverter");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate template(Jaxb2Marshaller marshaller) {

        WebServiceTemplate template = new WebServiceTemplate();

        template.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx?WSDL");
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        return  template;
    }
}
