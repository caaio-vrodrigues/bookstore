package portfolio.caio.bookstore.infrastructure.repository.sallablebook;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;

public interface BookRepositoryBase<T extends SallableBook> {
	T findByIsbn(String isbn);
}
