package com.alainnascimento.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alainnascimento.workshopmongo.domain.Post;
import com.alainnascimento.workshopmongo.domain.User;
import com.alainnascimento.workshopmongo.dto.AuthorDTO;
import com.alainnascimento.workshopmongo.repository.PostRepository;
import com.alainnascimento.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// Deleção Banco de dados:
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		// Criação usuários:

		User alain = new User(null, "Alain Vaz Nascimento", "alainvaz@gmail.com");
		User graciele = new User(null, "Graciele Jordane Tavares Pio Nascimento", "grapionascimento@gmail.com");
		User julia = new User(null, "Julia Pio Nascimento", "jujuba@gmail.com");
		User hector = new User(null, "Hector", "hectorssauro@gmail.com");
		
		userRepository.saveAll(Arrays.asList(alain, graciele, julia, hector));
		
		// Criação postagens:
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Biquinhas, abraços!", new AuthorDTO(alain));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(alain));	
		Post post3 = new Post(null, sdf.parse("23/03/2019"), "Após jantar.", "Quero outra coisa...", new AuthorDTO(julia));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		// Atualizando posts dos usuários:
		
		alain.getPosts().addAll(Arrays.asList(post1, post2));
		julia.getPosts().addAll(Arrays.asList(post3));
		
		userRepository.save(alain);
		userRepository.save(julia);
		
		
	}

}
