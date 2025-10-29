package portfolio.caio.bookstore.infrastructure.entity.dto.publisher;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.Country;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreatePublisherDTO {

	@NotBlank(message="O campo 'name' não estar em branco.")
	@NotEmpty(message="O campo 'name' não pode ser vazio.")
	private String name;
	
	@NotNull(message="O campo 'country' não pode ser nulo.")
	private Country country;
}
