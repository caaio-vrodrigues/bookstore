package portfolio.caio.bookstore.infrastructure.entity.sallablebook;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.Book;
import portfolio.caio.bookstore.model.interfaces.Seller;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class SallableBook extends Book implements Seller {
	
	@Column(name="price", nullable=false)
	private BigDecimal price;
	
	@Column(name="units", nullable=false)
	private Integer units;
}
