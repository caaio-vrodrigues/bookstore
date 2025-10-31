package portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.model.enums.booksession.RomanceSession;

@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class CreateRomanceBookDTO extends CreateSallableBookDTO {

	@NotNull(message="O campo 'session' não pode ser nulo.")
	private RomanceSession session;
}
