package portfolio.caio.bookstore.model.interfaces.genre;

public interface Adventure {

	String GENRE = "aventura";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
