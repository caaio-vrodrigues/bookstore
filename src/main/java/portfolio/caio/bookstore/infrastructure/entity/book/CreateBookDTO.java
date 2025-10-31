package portfolio.caio.bookstore.infrastructure.entity.book;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import portfolio.caio.bookstore.infrastructure.entity.author.Author;
import portfolio.caio.bookstore.infrastructure.entity.publisher.Publisher;

@MappedSuperclass
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public abstract class CreateBookDTO {
	
	@NotBlank(message="O campo 'title' não estar em branco.")
	@NotEmpty(message="O campo 'title' não pode ser vazio.")
	private String title;
	
	@NotNull(message="O campo 'author' não pode ser nulo.")
	private Author author;
	
	@NotNull(message="O campo 'publisher' não pode ser nulo.")
	private Publisher publisher;
	
	@NotBlank(message="O campo 'isbn' não estar em branco.")
	@NotEmpty(message="O campo 'isbn' não pode ser vazio.")
	private String isbn;
}
