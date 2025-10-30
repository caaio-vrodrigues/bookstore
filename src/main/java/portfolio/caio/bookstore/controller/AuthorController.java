package portfolio.caio.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.author.CreateAuthorDTO;
import portfolio.caio.bookstore.infrastructure.entity.author.UpdateAuthorDTO;
import portfolio.caio.bookstore.service.AuthorService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

	private final AuthorService service;
	
	@PostMapping
	public ResponseEntity<Author> newAuthor(@RequestBody CreateAuthorDTO body){
		return ResponseEntity.ok(service.createAuthor(body));
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> searchAllAuthors(){
		return ResponseEntity.ok(service.getAllAuthors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> searchAuthorById(@PathVariable Long id){
		return ResponseEntity.ok(service.getAuthorById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Author> editAuthorById(
		@PathVariable Long id, 
		@RequestBody UpdateAuthorDTO body
	) {
		return ResponseEntity.ok(service.updateAuthor(id, body));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excludeAuthor(@PathVariable Long id){
		return ResponseEntity.ok(service.deleteAuthorById(id));
	}
}
