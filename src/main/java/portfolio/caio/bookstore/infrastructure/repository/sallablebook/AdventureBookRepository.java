package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.AdventureBook;

@Repository
public interface AdventureBookRepository extends BookRepositoryBase<AdventureBook>, JpaRepository<AdventureBook, Long> {}
