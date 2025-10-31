package portfolio.caio.bookstore.infrastructure.entity.sallablebook;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.book.CreateBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.ActionBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.AdventureBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.ComedyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.DramaBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.FantasyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.RomanceBook;

@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeInfo(
	use=JsonTypeInfo.Id.NAME,
	include=JsonTypeInfo.As.PROPERTY,
	property="type"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value=ActionBook.class, name="actionBook"),
	@JsonSubTypes.Type(value=AdventureBook.class, name="adventureBook"),
	@JsonSubTypes.Type(value=ComedyBook.class, name="comedyBook"),
	@JsonSubTypes.Type(value=DramaBook.class, name="dramaBook"),
	@JsonSubTypes.Type(value=FantasyBook.class, name="fantasyBook"),
	@JsonSubTypes.Type(value=RomanceBook.class, name="romanceBook")
})
public abstract class CreateSallableBookDTO extends CreateBookDTO {
	
	@NotNull(message="O campo 'price' não pode ser nulo.")
	private BigDecimal price;
	
	@NotNull(message="O campo 'units' não pode ser nulo.")
	private Integer units;
}
