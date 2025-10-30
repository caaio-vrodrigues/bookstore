package portfolio.caio.bookstore.model.interfaces.genre;

public interface Drama {

	String GENRE = "drama";
	
	default String sectionMsg() {
		return "Esse filme pertence a sessção de filmes de "+GENRE;
	}
}
