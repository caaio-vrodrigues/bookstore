package portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.model.enums.booksession.FantasySession;

@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class CreateFantasyBookDTO extends CreateSallableBookDTO {

	@NotNull(message="O campo 'session' não pode ser nulo.")
	private FantasySession session;
}
