package portfolio.caio.bookstore.infrastructure.entity.dto.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateCountryDTO {

	@NotBlank(message="O código ISO Alpha-2 não pode ser vazio.")
	@NotNull(message="O código ISO Alpha-2 não pode ser nulo.")
	@Size(min=2, max=2, message="O código ISO Alpha-2 deve ter 2 caracteres.")
	private String isoAlpha2Code;
}

