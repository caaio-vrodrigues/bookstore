package portfolio.caio.bookstore.model.interfaces.genre;

public interface Action {

	String GENRE = "ação";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
