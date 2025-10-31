package portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.CreateSallableBookDTO;
import portfolio.caio.bookstore.model.enums.booksession.ComedySession;

@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateComedyBookDTO extends CreateSallableBookDTO {

	@NotNull(message="O campo 'session' não pode ser nulo.")
	private ComedySession session;
}
