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
import lombok.experimental.SuperBuilder;
import portfolio.caio.bookstore.infrastructure.entity.book.CreateBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.CreateActionBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.CreateAdventureBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.CreateComedyBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.CreateDramaBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.CreateFantasyBookDTO;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.CreateRomanceBookDTO;

@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@JsonTypeInfo(
	use=JsonTypeInfo.Id.NAME,
	include=JsonTypeInfo.As.PROPERTY,
	property="type"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value=CreateActionBookDTO.class, name="actionBook"),
    @JsonSubTypes.Type(value=CreateAdventureBookDTO.class, name="adventureBook"),
    @JsonSubTypes.Type(value=CreateComedyBookDTO.class, name="comedyBook"),      
    @JsonSubTypes.Type(value=CreateDramaBookDTO.class, name="dramaBook"),
    @JsonSubTypes.Type(value=CreateFantasyBookDTO.class, name="fantasyBook"),
    @JsonSubTypes.Type(value=CreateRomanceBookDTO.class, name="romanceBook")
})
public abstract class CreateSallableBookDTO extends CreateBookDTO {
	
	@NotNull(message="O campo 'price' não pode ser nulo.")
	private BigDecimal price;
	
	@NotNull(message="O campo 'units' não pode ser nulo.")
	private Integer units;
}
