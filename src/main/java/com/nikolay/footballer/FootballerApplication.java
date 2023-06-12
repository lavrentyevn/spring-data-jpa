package com.nikolay.footballer;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class FootballerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FootballerRepository footballerRepository) {
		return args -> {
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@gmail.com", firstName, lastName);
			Footballer footballer = new Footballer(
					firstName,
					lastName,
					email,
					LocalDateTime.now().minusYears(25));

			FootballerIdCard footballerIdCard = new FootballerIdCard(
				"123123123",
				footballer
			);

			footballer.setFootballerIdCard(footballerIdCard);

			footballer.addTransfer(new TransferHistory(
					"AC Milan",
					LocalDateTime.now().minusYears(10)));

			footballer.addAwarding(new Awarding(
					new AwardingId(1L, 1L),
					footballer,
					new Achievement("World Cup", "National"),
					LocalDateTime.now().minusYears(2)
			));


			footballerRepository.save(footballer);
		};
	}
}
