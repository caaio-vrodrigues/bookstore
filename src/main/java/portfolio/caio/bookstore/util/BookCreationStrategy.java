package portfolio.caio.bookstore.util;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.BookRepositoryBase;

@RequiredArgsConstructor
public abstract class BookCreationStrategy
	<D extends CreateSallableBookDTO, 
	C extends SallableBook, 
	R extends JpaRepository<C, Long> & BookRepositoryBase<C>> 
{
    protected final R repository;
    protected abstract C createSpecificBookEntity(D dto, Author author, Publisher publisher);

    @SuppressWarnings("unchecked")
    public SallableBook createAndSaveBook(
        CreateSallableBookDTO genericDto, Author author, Publisher publisher
    ) {
        C existingBookByIsbn = repository.findByIsbn(genericDto.getIsbn());
        if (existingBookByIsbn != null) throw new RuntimeException("O ISBN: "+existingBookByIsbn.getIsbn()+" já foi utilizado para o livro: "+existingBookByIsbn.getTitle());
        C newBook = createSpecificBookEntity((D) genericDto, author, publisher);
        return repository.saveAndFlush(newBook);
    }
}
