package portfolio.caio.bookstore.infrastructure.entity.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

	@NotBlank(message="O código ISO Alpha-2 não estar em branco.")
	@NotEmpty(message="O código ISO Alpha-2 não pode ser vazio.")
	@Size(min=2, max=2, message="O código ISO Alpha-2 deve ter 2 caracteres.")
	private String isoAlpha2Code;
}

