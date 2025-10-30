package portfolio.caio.bookstore.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;
import portfolio.caio.bookstore.infrastructure.entity.country.CreateCountryDTO;
import portfolio.caio.bookstore.infrastructure.repository.CountryRepository;

@RequiredArgsConstructor
@Service
public class CountryService {

	private final CountryRepository repo;

	public Country createCountry(CreateCountryDTO body) {
		String normalizedIsoAlpha2Code = body.getIsoAlpha2Code().trim().toUpperCase();
		if (!normalizedIsoAlpha2Code.matches("[A-Z]{2}")) throw new IllegalArgumentException("Erro: O código ISO Alpha-2 deve ter 2 letras maiúsculas.");		
		boolean validIsoCode = Arrays
			.asList(Locale.getISOCountries())
            .contains(normalizedIsoAlpha2Code);
		if (!validIsoCode) throw new IllegalArgumentException("Error: O código ISO Alpha-2 '"+normalizedIsoAlpha2Code+"' não corresponde a um país reconhecido.");		
	    Country existingCountry = repo.findByIsoAlpha2Code(normalizedIsoAlpha2Code);
	    if (existingCountry != null) return existingCountry;	    
	    Locale country = new Locale.Builder()
	    	.setRegion(normalizedIsoAlpha2Code)
	    	.build();
	    String countryName = country.getDisplayCountry(Locale.ENGLISH);        
	    Country newCountry = Country.builder()
	    	.isoAlpha2Code(normalizedIsoAlpha2Code)
	    	.name(countryName)
	    	.build();		
		return repo.saveAndFlush(newCountry);
	}

	public List<Country> getAllCountries() {
		return repo.findAll();
	}
	
	public Country getCountryByIsoCode(String isoCode) {
		return repo.findByIsoAlpha2Code(isoCode);
	}
	
	public Country getCountryById(Integer id) {
		return repo.findById(id).orElseThrow(() ->
		 new IllegalArgumentException("País com id: "+id+", não encontrado"));
	}
}
