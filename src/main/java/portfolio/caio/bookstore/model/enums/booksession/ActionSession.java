package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ActionSession {

	ACTION_0("AC-0", 0),
	ACTION_12("AC-12", 12),
	ACTION_14("AC-14", 14),
	ACTION_16("AC-16", 16),
	ACTION_18("AC-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
