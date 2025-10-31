package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AdventureSession {

	ADVENTURE_0("ADV-0", 0),
	ADVENTURE_12("ADV-12", 12),
	ADVENTURE_14("ADV-14", 14),
	ADVENTURE_16("ADV-16", 16),
	ADVENTURE_18("ADV-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
