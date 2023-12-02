package br.com.monstro.fakeapied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FakeApiEdApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeApiEdApplication.class, args);
	}

}
