package yokudlela.books.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode()
@Entity
@javax.persistence.Table(name = "library")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Schema(description = "Library class")
public class Library {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NotBlank(message = "error.library.name.notset")
    @NotNull(message = "error.library.name.notset")
    @Schema(description = "Name of the library")
    private String name;

    @Schema(description = "Books in the library")
    @ManyToMany(fetch = FetchType.LAZY )
    @JoinColumn(name="book_id", nullable=false)
    private List<Book> books = new ArrayList<>();

    @Builder
    public Library(String name)
    {
        this.name = name;
    }
}
