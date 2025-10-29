package portfolio.caio.bookstore.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(unique=true, length=2, nullable=false)
	private String isoAlpha2Code;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
}
