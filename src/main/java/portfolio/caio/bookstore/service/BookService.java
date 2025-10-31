package portfolio.caio.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.util.BookCreationRegistry;
import portfolio.caio.bookstore.util.BookCreationStrategy;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;

@Service
@RequiredArgsConstructor
public class BookService {

    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookCreationRegistry bookCreationRegistry;

    @SuppressWarnings("rawtypes")
	public SallableBook createBook(CreateSallableBookDTO body) {
        BookCreationStrategy strategy = bookCreationRegistry.getStrategy(body.getClass());
        if (strategy == null) throw new IllegalArgumentException("Tipo de livro não suportado para criação: " + body.getClass().getSimpleName());
        Author author = authorService.getAuthorById(body.getAuthor().getId());
        Publisher publisher = publisherService.getPublisherById(body.getPublisher().getId());
        return strategy.createAndSaveBook(body, author, publisher);
    }
    
    public List<SallableBook> getAllSallableBooks(){
    	return null;
    }
}
