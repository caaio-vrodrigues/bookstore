package portfolio.caio.bookstore.model.interfaces.genre;

public interface Comedy {

	String GENRE = "comédia";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
