package portfolio.caio.bookstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.Author;
import portfolio.caio.bookstore.infrastructure.entity.Country;
import portfolio.caio.bookstore.infrastructure.entity.dto.author.CreateAuthorDTO;
import portfolio.caio.bookstore.infrastructure.entity.dto.author.UpdateAuthorDTO;
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
		if(existingAuthor != null ) return existingAuthor;
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
		if(containsCountry) 
			potentialCountry = countryService.getCountryById(body.getCountry().getId());
		Author authorByFullNameAndBirthDayAndCountry = repo.findByFullNameAndBirthDayAndCountry(
           potentialFullName, potentialBirthDay, potentialCountry
        );
		boolean existsAuthorByFullNameAndBirthDayAndCountry = 
			authorByFullNameAndBirthDayAndCountry != null;
		if(existsAuthorByFullNameAndBirthDayAndCountry) {
			boolean isTheExistingAuthor = authorByFullNameAndBirthDayAndCountry.getId().equals(
				existingAuthor.getId());
	        if(!isTheExistingAuthor) throw new IllegalArgumentException("An author with the same full name, birth day, and country already exists.");
	        return existingAuthor;
		}
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
