package com.alainnascimento.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alainnascimento.workshopmongo.domain.User;
import com.alainnascimento.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User alain = new User(null, "Alain Vaz Nascimento", "alainvaz@gmail.com");
		User graciele = new User(null, "Graciele Jordane Tavares Pio Nascimento", "grapionascimento@gmail.com");
		User julia = new User(null, "Julia Pio Nascimento", "jujuba@gmail.com");
		User hector = new User(null, "Hector", "hectorssauro@gmail.com");
		
		userRepository.saveAll(Arrays.asList(alain, graciele, julia, hector));
		
	}

}
