package ra.btvn.controller;

import ra.btvn.model.dto.request.AuthorDTO;
import ra.btvn.model.dto.respone.ApiDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn.model.entity.Author;
import ra.btvn.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Author>>> getAuthors() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get list authors successfully!",
                authorService.getAllAuthors(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Author>> addAuthors(@RequestBody Author author) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Added author successfully!",
                authorService.createAuthor(author),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Author>> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Updated author successfully!",
                authorService.updateAuthor(id, author),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Author>> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Deleted author successfully!",
                null,
                null,
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Author>> patchUpdateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Updated author successfully!",
                authorService.updateAuthor1(id, authorDTO),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
