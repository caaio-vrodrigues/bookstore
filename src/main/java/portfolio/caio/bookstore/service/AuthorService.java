package portfolio.caio.bookstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.author.CreateAuthorDTO;
import portfolio.caio.bookstore.infrastructure.entity.author.UpdateAuthorDTO;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;
import portfolio.caio.bookstore.infrastructure.repository.AuthorRepository;

@RequiredArgsConstructor
@Service
public class AuthorService {

	private final AuthorRepository repo;
	private final CountryService countryService;

	public Author createAuthor(CreateAuthorDTO body) {
		Country country = countryService.getCountryById(body.getCountry().getId());
		Author existingAuthor = repo.findByFullNameAndBirthDayAndCountry(
           body.getFullName(), body.getBirthDay(), country
        );
		boolean authorAlreadyExists = existingAuthor != null;
		if(authorAlreadyExists) return existingAuthor;
		Author newAuthor = Author.builder()
			.fullName(body.getFullName())	
			.birthDay(body.getBirthDay())
			.country(country)
			.build();
		return repo.saveAndFlush(newAuthor);
	}
	
	public List<Author> getAllAuthors(){
		return repo.findAll();
	}
	
	public Author getAuthorById(Long id) {
		return repo.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Autor com id: "+id+" não encontrado"));
	}
	
	public Author updateAuthor(Long id, UpdateAuthorDTO body) {
		Author existingAuthor = getAuthorById(id);
		boolean containsFullName = body.getFullName() != null;
		boolean containsBirthDay = body.getBirthDay() != null;
		boolean containsCountry = body.getCountry() != null;
		String potentialFullName = containsFullName ? 
			body.getFullName() : existingAuthor.getFullName();
		LocalDate potentialBirthDay = containsBirthDay ? 
			body.getBirthDay() : existingAuthor.getBirthDay();
		Country potentialCountry = existingAuthor.getCountry();
		if(containsCountry) {
			boolean isSameCountry = existingAuthor.getCountry().getId().equals(
				body.getCountry().getId());
			if(!isSameCountry) 
				potentialCountry = countryService.getCountryById(body.getCountry().getId());
		}
		Author potentialAuthor = repo.findByFullNameAndBirthDayAndCountry(
			potentialFullName, potentialBirthDay, potentialCountry
        );
		boolean potentialAuthorAlreadyExists = potentialAuthor != null;
		if(potentialAuthorAlreadyExists) return potentialAuthor;
		existingAuthor.setFullName(potentialFullName);
		existingAuthor.setBirthDay(potentialBirthDay);
		existingAuthor.setCountry(potentialCountry);
		return repo.saveAndFlush(existingAuthor);
	}
	
	public boolean deleteAuthorById(Long id) {
		if(!repo.existsById(id)) throw new IllegalArgumentException("Autor com id: "+id+" não encontrado");
		repo.deleteById(id);
		return true;
	}
}
