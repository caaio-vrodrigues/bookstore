package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RomanceSession {

	ROMANCE_0("RMC-0", 0),
	ROMANCE_12("RMC-12", 12),
	ROMANCE_14("RMC-14", 14),
	ROMANCE_16("RMC-16", 16),
	ROMANCE_18("RMC-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
