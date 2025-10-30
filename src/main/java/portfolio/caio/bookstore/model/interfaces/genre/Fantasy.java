package portfolio.caio.bookstore.model.interfaces.genre;

public interface Fantasy {

	String GENRE = "fantasia";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
