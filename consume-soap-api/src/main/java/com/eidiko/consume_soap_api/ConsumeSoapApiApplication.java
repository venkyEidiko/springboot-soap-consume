package com.eidiko.consume_soap_api;

import com.eidiko.consume_soap_api.client.TemperatureConverterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumeSoapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeSoapApiApplication.class, args);
		TemperatureConverterClient temperatureConverterClient = new TemperatureConverterClient();
//		temperatureConverterClient.
	}

}
