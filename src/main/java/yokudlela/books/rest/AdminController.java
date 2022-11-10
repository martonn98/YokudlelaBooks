package yokudlela.books.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import yokudlela.books.datamodel.Book;
import yokudlela.books.datamodel.Library;
import yokudlela.books.store.BookRepository;
import yokudlela.books.store.LibraryRepository;

@RestController()
@RequestMapping(path = "/admin")
@Validated
public class AdminController {
    @Autowired(required = true)
    private LibraryRepository LibraryService;

    @Autowired(required = true)
    private BookRepository BookService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Library.class)) }),
            @ApiResponse(responseCode = "500", description = "Already exists",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(
            security = {
                    @SecurityRequirement(name = "apikey",scopes = {"library"}),
                    @SecurityRequirement(name = "openid",scopes = {"library"}),
                    @SecurityRequirement(name = "oauth2",scopes = {"library"}),
            },
            summary = "Add new library")
    @PostMapping(path = "/addLibrary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Library addLibrary(
            @Valid
            @Parameter(description = "The new library", required = true)
            @RequestBody(required = true) Library pData) throws Exception {
        LibraryService.save(pData);
        return pData;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "500", description = "Already exists",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(
            security = {
                    @SecurityRequirement(name = "apikey",scopes = {"library"}),
                    @SecurityRequirement(name = "openid",scopes = {"library"}),
                    @SecurityRequirement(name = "oauth2",scopes = {"library"}),
            },
            summary = "Add new book")
    @PostMapping(path = "/addBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(
            @Valid
            @Parameter(description = "The new book", required = true)
            @RequestBody(required = true) Book pData) throws Exception {
        BookService.save(pData);
        return pData;
    }
}
