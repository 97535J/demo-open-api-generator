package com.client.java;

import com.example.client.api.PetApi;
import com.example.client.model.Pet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PetApi petApi = new PetApi();
		Pet pet = petApi.getPetById(22L);
		System.out.println(pet);
	}
}
