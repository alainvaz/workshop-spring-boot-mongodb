package com.alainnascimento.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alainnascimento.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List <Post> findByTitleContainingIgnoreCase(String text);
	
	// Query personalizada
	@Query("{ 'title': {$regex: ?0,$options: 'i'}}") // ?0 é o parametro e i para ser ignore case
	List <Post> seachTitle(String text);
	
}
