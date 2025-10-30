package portfolio.caio.bookstore.infrastructure.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.Author;
import portfolio.caio.bookstore.infrastructure.entity.Country;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	Author findByFullName(String fullName);

	Author findByFullNameAndBirthDayAndCountry(
		String potentialFullName, 
		LocalDate potentialBirthDay, 
		Country potentialCountry
	);
}
