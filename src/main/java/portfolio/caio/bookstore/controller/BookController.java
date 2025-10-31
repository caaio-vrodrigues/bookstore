package portfolio.caio.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;
import portfolio.caio.bookstore.service.BookService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
	
	private final BookService service;

	@PostMapping
	public ResponseEntity<SallableBook> newBook(@RequestBody CreateSallableBookDTO body){
		return ResponseEntity.ok(service.createBook(body));
	}
	
	@GetMapping
	public ResponseEntity<List<SallableBook>> findAllSallableBooksByType(){
		return ResponseEntity.ok(service.getAllSallableBooks());
	}
}
