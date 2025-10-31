package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FantasySession {

	FANTASY_0("FTS-0", 0),
	FANTASY_12("FTS-12", 12),
	FANTASY_14("FTS-14", 14),
	FANTASY_16("FTS-16", 16),
	FANTASY_18("FTS-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
