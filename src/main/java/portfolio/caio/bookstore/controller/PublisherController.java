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
import portfolio.caio.bookstore.infrastructure.entity.publisher.CreatePublisherDTO;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;
import portfolio.caio.bookstore.infrastructure.entity.publisher.UpdatePublisherDTO;
import portfolio.caio.bookstore.service.PublisherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {

	private final PublisherService service;
	
	@PostMapping
	public ResponseEntity<Publisher> newPublisher(@RequestBody CreatePublisherDTO body){
		return ResponseEntity.ok(service.createPublisher(body));
	}
	
	@GetMapping
	public ResponseEntity<List<Publisher>> findAllPublishers(){
		return ResponseEntity.ok(service.getAllPublishers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Publisher> searchPublisherById(@PathVariable Integer id){
		return ResponseEntity.ok(service.getPublisherById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Publisher> editPublisherById(
		@PathVariable Integer id, 
		@RequestBody UpdatePublisherDTO body
	) {
		return ResponseEntity.ok(service.updatePublisher(id, body));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excludePublisherById(@PathVariable Integer id){
		return ResponseEntity.ok(service.deletePublisher(id));
	}
}
