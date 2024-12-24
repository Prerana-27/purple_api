package org.jsp.purple_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Purple Rest API",description = "Rest Api using spring boot for performing crud operations",version = "1.4.3",contact = @Contact(url = "https://www.github.com/preranapawale",name="Prerana Pawale",email = "prepawale2002@gmail.com")))
public class PurpleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurpleApiApplication.class, args);
	}

}
