package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.DramaBook;

@Repository
public interface DramaBookRepository extends BookRepositoryBase<DramaBook>, JpaRepository<DramaBook, Long> {}
