package portfolio.caio.bookstore.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.Country;
import portfolio.caio.bookstore.infrastructure.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	Publisher findByNameAndCountry(String name, Country country);
}
