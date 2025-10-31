package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.ComedyBook;

@Repository
public interface ComedyBookRepository extends JpaRepository<ComedyBook, Long> {}
