package portfolio.caio.bookstore.infrastructure.entity.publisher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.country.Country;

@Entity
@Table(name="publisher")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country", nullable=false)
	private Country country;
}
