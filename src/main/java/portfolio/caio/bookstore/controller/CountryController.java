package portfolio.caio.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;
import portfolio.caio.bookstore.infrastructure.entity.country.CreateCountryDTO;
import portfolio.caio.bookstore.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

	private final CountryService service;
	
	@PostMapping
	public ResponseEntity<Country> newCountry(@RequestBody CreateCountryDTO body){
		return ResponseEntity.ok(service.createCountry(body));
	}
	
	@GetMapping
	public ResponseEntity<List<Country>> searchAllCountries(){
		return ResponseEntity.ok(service.getAllCountries());
	}
	
	@GetMapping("/{isoCode}")
	public ResponseEntity<Country> searchByIsoCode(@PathVariable String isoCode){
		return ResponseEntity.ok(service.getCountryByIsoCode(isoCode));
	}
}
