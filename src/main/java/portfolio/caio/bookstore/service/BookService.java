package portfolio.caio.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.ActionBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.CreateActionBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.AdventureBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.CreateAdventureBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.ComedyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.CreateComedyBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.CreateDramaBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.DramaBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.CreateFantasyBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.FantasyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.CreateRomanceBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.RomanceBook;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.ActionBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.AdventureBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.BookRepositoryBase;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.ComedyBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.DramaBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.FantasyBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.RomanceBookRepository;

@Service
@RequiredArgsConstructor
public class BookService {

    private final ActionBookRepository actionBookRepository;
    private final AdventureBookRepository adventureBookRepository;
    private final ComedyBookRepository comedyBookRepository;
    private final DramaBookRepository dramaBookRepository;
    private final FantasyBookRepository fantasyBookRepository;
    private final RomanceBookRepository romanceBookRepository;

    private final AuthorService authorService;
    private final PublisherService publisherService;
    
    private abstract class BookCreationStrategy
    	<D extends CreateSallableBookDTO, 
    	C extends SallableBook, 
    	R extends JpaRepository<C, Long> & BookRepositoryBase<C>> 
	{
	    protected final R repository;
	
	    public BookCreationStrategy(R repository) {
	        this.repository = repository;
	    }
	
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

	private final Map<Class<? extends CreateSallableBookDTO>, BookCreationStrategy> 
    	bookCreationStrategies = new HashMap<>();

    @PostConstruct
    public void init() {
        bookCreationStrategies.put(
        	CreateActionBookDTO.class, 
        	new BookCreationStrategy<
        		CreateActionBookDTO, 
        		ActionBook, 
        		ActionBookRepository>(actionBookRepository)
        	{
	            @Override
	            protected ActionBook createSpecificBookEntity(
	            	CreateActionBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return ActionBook.builder()
	                    .author(author)
	                    .price(dto.getPrice())
	                    .isbn(dto.getIsbn())
	                    .publisher(publisher)
	                    .session(dto.getSession())
	                    .title(dto.getTitle())
	                    .units(dto.getUnits())
	                    .build();
            	}
        	});

        bookCreationStrategies.put(
    		CreateAdventureBookDTO.class, 
    		new BookCreationStrategy<
    			CreateAdventureBookDTO, 
    			AdventureBook,
    			AdventureBookRepository>(adventureBookRepository)
    		{
	            @Override
	            protected AdventureBook createSpecificBookEntity(
	            	CreateAdventureBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return AdventureBook.builder()
                        .author(author)
                        .price(dto.getPrice())
                        .isbn(dto.getIsbn())
                        .publisher(publisher)
                        .session(dto.getSession())
                        .title(dto.getTitle())
                        .units(dto.getUnits())
                        .build();
	            }
    		});

        bookCreationStrategies.put(
        	CreateComedyBookDTO.class, 
        	new BookCreationStrategy<
        		CreateComedyBookDTO, 
        		ComedyBook,
        		ComedyBookRepository>(comedyBookRepository) 
        	{
	            @Override
	            protected ComedyBook createSpecificBookEntity(
	            	CreateComedyBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return ComedyBook.builder()
                        .author(author)
                        .price(dto.getPrice())
                        .isbn(dto.getIsbn())
                        .publisher(publisher)
                        .title(dto.getTitle())
                        .units(dto.getUnits())
                        .build();
	            }
        	});

        bookCreationStrategies.put(
        	CreateDramaBookDTO.class, 
        	new BookCreationStrategy<
        		CreateDramaBookDTO, 
        		DramaBook,
        		DramaBookRepository>(dramaBookRepository) 
        	{
	            @Override
	            protected DramaBook createSpecificBookEntity(
	            	CreateDramaBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return DramaBook.builder()
                        .author(author)
                        .price(dto.getPrice())
                        .isbn(dto.getIsbn())
                        .publisher(publisher)
                        .session(dto.getSession())
                        .title(dto.getTitle())
                        .units(dto.getUnits())
                        .build();
	            }
        	});

        bookCreationStrategies.put(
        	CreateFantasyBookDTO.class, 
        	new BookCreationStrategy<
        		CreateFantasyBookDTO, 
        		FantasyBook,
        		FantasyBookRepository>(fantasyBookRepository) 
        	{
	            @Override
	            protected FantasyBook createSpecificBookEntity(
	            	CreateFantasyBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return FantasyBook.builder()
                        .author(author)
                        .price(dto.getPrice())
                        .isbn(dto.getIsbn())
                        .publisher(publisher)
                        .session(dto.getSession())
                        .title(dto.getTitle())
                        .units(dto.getUnits())
                        .build();
	            }
        	});

        bookCreationStrategies.put(
        	CreateRomanceBookDTO.class, 
        	new BookCreationStrategy<
        		CreateRomanceBookDTO, 
        		RomanceBook,
        		RomanceBookRepository>(romanceBookRepository) 
        	{
	            @Override
	            protected RomanceBook createSpecificBookEntity(
	            	CreateRomanceBookDTO dto, 
	            	Author author, 
	            	Publisher publisher
	            ) {
	                return RomanceBook.builder()
                        .author(author)
                        .price(dto.getPrice())
                        .isbn(dto.getIsbn())
                        .publisher(publisher)
                        .session(dto.getSession())
                        .title(dto.getTitle())
                        .units(dto.getUnits())
                        .build();
	            }
	        });
    }
    

    @SuppressWarnings("rawtypes")
	public SallableBook createBook(CreateSallableBookDTO body) {
        // Encontra a estratégia de criação apropriada com base no tipo de DTO
        BookCreationStrategy strategy = bookCreationStrategies.get(body.getClass());

        if (strategy == null) throw new IllegalArgumentException("Tipo de livro não suportado para criação: " + body.getClass().getSimpleName());

        // Busca o Autor e a Editora (lógica comum)
        Author author = authorService.getAuthorById(body.getAuthor().getId());
        Publisher publisher = publisherService.getPublisherById(body.getPublisher().getId());

        // Delega a criação e salvamento à estratégia específica
        return strategy.createAndSaveBook(body, author, publisher);
    }
}
