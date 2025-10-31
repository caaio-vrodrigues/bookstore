package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ComedySession {
	
	COMEDY_0("CM-0", 0),
	COMEDY_12("CM-12", 12),
	COMEDY_14("CM-14", 14),
	COMEDY_16("CM-16", 16),
	COMEDY_18("CM-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
