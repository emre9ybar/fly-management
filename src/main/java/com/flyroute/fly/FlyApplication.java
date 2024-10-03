package com.flyroute.fly;

import com.flyroute.fly.message.AirlineMessage;
import com.flyroute.fly.message.UserMessage;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	@Bean
	public UserMessage userMessage(){
		return new UserMessage();
	}
	@Bean
	public AirlineMessage airlineMessage() { return new AirlineMessage(); }

}
