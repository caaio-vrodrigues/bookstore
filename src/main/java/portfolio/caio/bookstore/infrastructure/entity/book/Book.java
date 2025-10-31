package portfolio.caio.bookstore.infrastructure.entity.book;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;

@MappedSuperclass
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Book {

	@Column(name="title", nullable=false)
	private String title;
	
	@ManyToOne
	@JoinColumn(name="author", nullable=false)
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="publisher", nullable=false)
	private Publisher publisher;
	
	@Column(name="isbn", nullable=false, unique=true)
	private String isbn;
}
