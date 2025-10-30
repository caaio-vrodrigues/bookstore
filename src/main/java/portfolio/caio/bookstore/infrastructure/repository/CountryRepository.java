package portfolio.caio.bookstore.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	Country findByIsoAlpha2Code(String isoAlpha2Code);
}
