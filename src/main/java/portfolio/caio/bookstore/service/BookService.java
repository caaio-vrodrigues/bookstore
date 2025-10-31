package portfolio.caio.bookstore.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.book.CreateBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.ActionBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.AdventureBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.ComedyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.DramaBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.FantasyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.RomanceBook;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.ActionBookRepository;
import portfolio.caio.bookstore.infrastructure.repository.sallablebook.AdventureBookRepository;
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
	
	private Map<Class<? extends SallableBook>, JpaRepository<? extends SallableBook, Long>> repositoryMap;
	private Map<String, Class<? extends SallableBook>> typeToClassMap;
	
	@PostConstruct
	@SuppressWarnings("unchecked")
	private void initReposityMaps() {
		repositoryMap = new HashMap<>();
		repositoryMap.put(ActionBook.class, actionBookRepository);
		repositoryMap.put(AdventureBook.class, adventureBookRepository);
		repositoryMap.put(ComedyBook.class, comedyBookRepository);
		repositoryMap.put(DramaBook.class, dramaBookRepository);
		repositoryMap.put(FantasyBook.class, fantasyBookRepository);
		repositoryMap.put(RomanceBook.class, romanceBookRepository);
		typeToClassMap = Arrays
			.stream(SallableBook.class.getAnnotation(JsonSubTypes.class).value())
			.collect(Collectors.toMap(
				JsonSubTypes.Type::name, type -> (Class<? extends SallableBook>) type.value()));
	}
	
	@SuppressWarnings("unchecked")
	private JpaRepository<SallableBook, Long> getRepository(Class<? extends SallableBook> sallableClass){
		JpaRepository<? extends SallableBook, Long> repoByClass = repositoryMap.get(sallableClass);
		if(repoByClass == null) throw new RuntimeException("Repositório não existe");
		return (JpaRepository<SallableBook, Long>) repoByClass;
	}

	public SallableBook createBook(CreateBookDTO body) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
