package portfolio.caio.bookstore.infrastructure.entity;

import java.time.LocalDate;

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

@Entity
@Table(name="author")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="full_name", nullable=false)
	public String fullName;
	
	@Column(name="birthday", nullable=false)
	public LocalDate birthDay;
	
	@ManyToOne
	@JoinColumn(name="country", nullable=false)
	public Country country;
}
