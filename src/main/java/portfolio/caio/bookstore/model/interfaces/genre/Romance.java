package portfolio.caio.bookstore.model.interfaces.genre;

public interface Romance {

	String GENRE = "romance";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
