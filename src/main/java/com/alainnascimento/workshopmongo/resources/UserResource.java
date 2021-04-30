package com.alainnascimento.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alainnascimento.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	
	@RequestMapping(method=RequestMethod.GET)
	
	public ResponseEntity< List<User> >findAll(){
		
		User julia = new User("1", "Julia Pio Nascimento", "jujuba@gmail.com");
		User alain = new User("2", "Alain Vaz Nascimento", "alainvaz@gmail.com");
		
		List<User>list = new ArrayList<>();
		
		list.addAll(Arrays.asList(julia, alain));
		
		return ResponseEntity.ok().body(list);
					
	}

}
