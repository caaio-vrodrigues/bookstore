package portfolio.caio.bookstore.infrastructure.entity.sallablebook;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import portfolio.caio.bookstore.infrastructure.entity.book.Book;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.action.ActionBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure.AdventureBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.comedy.ComedyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.drama.DramaBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.fantasy.FantasyBook;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.romance.RomanceBook;
import portfolio.caio.bookstore.model.interfaces.Sallable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
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
public abstract class SallableBook extends Book implements Sallable {
	
	@Column(name="price", nullable=false)
	private BigDecimal price;
	
	@Column(name="units", nullable=false)
	private Integer units;
}
