package com.alainnascimento.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alainnascimento.workshopmongo.domain.Post;
import com.alainnascimento.workshopmongo.repository.PostRepository;
import com.alainnascimento.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String text){
		
		String acao = "2"; // 2 igual consulta personalizada
		
		if (acao.equals("1")) {			
			return repo.findByTitleContainingIgnoreCase(text);
		}else {
			return repo.seachTitle(text); 
		}
	}


}
