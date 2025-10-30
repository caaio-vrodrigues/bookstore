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
		Publisher existingPublisher = repo.findByNameAndCountry(body.getName(), country);
		boolean publisherAlreadyExists = existingPublisher != null;
		if(publisherAlreadyExists) return existingPublisher;
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
		boolean containsName = body.getName() != null;
		boolean containsCountry = body.getCountry() != null;
		String potentialName = containsName ? 
			body.getName() : existingPublisher.getName();
		Country potentialCountry = existingPublisher.getCountry();
		if(containsCountry) {
			boolean isSameCountry = existingPublisher.getCountry().getId().equals(
				body.getCountry().getId());
			if(!isSameCountry) 
				potentialCountry = countryService.getCountryById(body.getCountry().getId());
		}
		Publisher potentialPublisher = repo.findByNameAndCountry(potentialName, potentialCountry);
		boolean potentialPublisherAlreadyExists = potentialPublisher != null;
		if(potentialPublisherAlreadyExists) return potentialPublisher;
		existingPublisher.setName(potentialName);
		existingPublisher.setCountry(potentialCountry);
		return repo.saveAndFlush(existingPublisher);
	}
	
	public Boolean deletePublisher(Integer id) {
		if(!repo.existsById(id)) throw new IllegalArgumentException("Editora com id: "+id+" não encontrada");
		repo.deleteById(id);
		return true;
	}
}
