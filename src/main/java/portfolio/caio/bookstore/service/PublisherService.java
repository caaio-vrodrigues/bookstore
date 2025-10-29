package portfolio.caio.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.Country;
import portfolio.caio.bookstore.infrastructure.entity.Publisher;
import portfolio.caio.bookstore.infrastructure.entity.dto.publisher.CreatePublisherDTO;
import portfolio.caio.bookstore.infrastructure.entity.dto.publisher.UpdatePublisherDTO;
import portfolio.caio.bookstore.infrastructure.repository.PublisherRepository;

@RequiredArgsConstructor
@Service
public class PublisherService {

	private final PublisherRepository repo;
	private final CountryService countryService;

	public Publisher createPublisher(CreatePublisherDTO body) {
		Country country = countryService.getCountryById(body.getCountry().getId());
		Publisher newPublisher = Publisher.builder()
			.name(body.getName())
			.country(country)
			.build();
		return repo.saveAndFlush(newPublisher);
	}
	
	public List<Publisher> getAllPublishers(){
		return repo.findAll();
	}
	
	public Publisher getPublisherById(Integer id) {
		return repo.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Editora com id: "+id+" não encontrada"));
	}
	
	public Publisher updatePublisher(Integer id, UpdatePublisherDTO body) {
		Publisher existingPublisher = getPublisherById(id);
		if(body.getName() != null) existingPublisher.setName(body.getName());
		if(body.getCountry() != null) {
			Country newCountry = countryService.getCountryById(body.getCountry().getId());
			existingPublisher.setCountry(newCountry);
		}
		return repo.saveAndFlush(existingPublisher);
	}
	
	public Boolean deletePublisher(Integer id) {
		if(!repo.existsById(id)) throw new IllegalArgumentException("Editora com id: "+id+" não encontrada");
		repo.deleteById(id);
		return true;
	}
}
