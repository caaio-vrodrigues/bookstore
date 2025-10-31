package portfolio.caio.bookstore.model.enums.booksession;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DramaSession {

	DRAMA_0("DRM-0", 0),
	DRAMA_12("DRM-12", 12),
	DRAMA_14("DRM-14", 14),
	DRAMA_16("DRM-16", 16),
	DRAMA_18("DRM-18", 18);
	
	private final String sessionCode;
	private final Integer ageRating;
}
