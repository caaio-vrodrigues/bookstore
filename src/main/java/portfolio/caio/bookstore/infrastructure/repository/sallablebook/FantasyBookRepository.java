package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.FantasyBook;

@Repository
public interface FantasyBookRepository extends BookRepositoryBase<FantasyBook>, JpaRepository<FantasyBook, Long> {}
