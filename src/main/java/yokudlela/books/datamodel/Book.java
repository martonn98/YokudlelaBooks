package yokudlela.books.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Schema(description = "Book class")
@Entity
@javax.persistence.Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotBlank(message = "error.book.name.notset")
    @NotNull(message = "error.book.name.notset")
    @Schema(description = "Name of the book")
    private String name;

    @NotBlank(message = "error.book.author.notset")
    @NotNull(message = "error.book.author.notset")
    @Schema(description = "Author of the book")
    private String author;

    @Builder
    public Book(String name, String author)
    {
        this.name = name;
        this.author = author;
    }
}
