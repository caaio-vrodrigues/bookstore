package portfolio.caio.bookstore.infrastructure.entity.sallablebook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.model.interfaces.genre.Drama;

@Entity
@Table(name="drama_book")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Builder
public class DramaBook extends SallableBook implements Drama {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
}
