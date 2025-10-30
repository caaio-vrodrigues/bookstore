package portfolio.caio.bookstore.infrastructure.entity.publisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdatePublisherDTO {
	
	private String name;
	private Country country;
}
