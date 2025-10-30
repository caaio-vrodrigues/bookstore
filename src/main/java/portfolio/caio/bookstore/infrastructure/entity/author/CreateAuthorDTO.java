package portfolio.caio.bookstore.infrastructure.entity.author;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateAuthorDTO {

	@NotBlank(message="O campo 'fullName' não estar em branco.")
	@NotEmpty(message="O campo 'fullName' não pode ser vazio.")
	public String fullName;
	
	@NotNull(message="O campo 'birthDay' não pode ser nulo.")
	public LocalDate birthDay;
	
	@NotNull(message="O campo 'country' não pode ser nulo.")
	public Country country;
}
