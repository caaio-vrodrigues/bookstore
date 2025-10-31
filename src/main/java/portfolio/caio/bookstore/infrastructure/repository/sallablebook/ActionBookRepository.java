package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.ActionBook;

@Repository
public interface ActionBookRepository extends BookRepositoryBase<ActionBook>, JpaRepository<ActionBook, Long> {}
