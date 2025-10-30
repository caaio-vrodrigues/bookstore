package portfolio.caio.bookstore.infrastructure.entity.dto.author;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.Country;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateAuthorDTO {

	public String fullName;
	public LocalDate birthDay;
	public Country country;
}
