package yokudlela.books.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import yokudlela.books.datamodel.Book;
import yokudlela.books.datamodel.Library;
import yokudlela.books.store.BookRepository;
import yokudlela.books.store.LibraryRepository;
import yokudlela.books.utils.logging.AspectLogger;

@RestController()
@RequestMapping(path = "/library")
public class LibraryController {
    @Autowired
    private LibraryRepository LibraryService;

    @Autowired
    private BookRepository BookService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Library.class)) }),
            @ApiResponse(responseCode = "500", description = "Unsuccessful",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Get all library")
    @GetMapping(path = "/getAllLibrary", produces = MediaType.APPLICATION_JSON_VALUE)
    @AspectLogger
    public List<Library> getAllLibrary()
    {
        return LibraryService.findAll();
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "500", description = "Unsuccessful",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Get all book")
    @GetMapping(path = "/getAllBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAllBook()
    {
        return BookService.findAll();
    }
}
