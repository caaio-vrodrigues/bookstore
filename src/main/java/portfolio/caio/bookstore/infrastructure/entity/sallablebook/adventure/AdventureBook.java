package portfolio.caio.bookstore.infrastructure.entity.sallablebook.adventure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;
import portfolio.caio.bookstore.model.enums.booksession.AdventureSession;
import portfolio.caio.bookstore.model.interfaces.genre.Adventure;

@Entity
@Table(name="adventure_book")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Builder
public class AdventureBook extends SallableBook implements Adventure {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="session", nullable=false)
	private AdventureSession session;
}
