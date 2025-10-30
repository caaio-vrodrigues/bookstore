package portfolio.caio.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;

@RestController
@RequiredArgsConstructor
@RequestMapping(name="book")
public class BookController {

	@PostMapping
	public ResponseEntity<SallableBook> newBook(){
		return ResponseEntity.ok(null);
	}
}
