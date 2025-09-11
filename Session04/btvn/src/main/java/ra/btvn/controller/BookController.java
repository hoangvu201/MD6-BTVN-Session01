package ra.btvn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn.model.dto.respone.ApiDataResponse;
import ra.btvn.model.entity.Book;
import ra.btvn.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Book>>> getBooks() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get list books successfully",
                bookService.getAllBooks(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Book>> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Add book successfully!",
                bookService.createBook(book, book.getAuthor().getId()),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @GetMapping("/by-author")
    public ResponseEntity<ApiDataResponse<List<Book>>> getBooksByAuthor(@RequestParam Long authorId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get books by author " + authorId + " successfully!",
                bookService.getBooksByAuthor(authorId),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiDataResponse<List<Book>>> getBooksByTitleOrAuthor(@RequestParam String title, @RequestParam String authorName) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get books by title "+title+" or author name " + authorName+ " successfully!",
                bookService.findBooksByTitleAndAuthorName(title,authorName),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Book>> updateBook(@PathVariable Long id, @RequestBody Book book, @RequestParam Long authorId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Updated book successfully!",
                bookService.updateBook(id,book,authorId),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Book>> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Deleted author successfully!",
                null,
                null,
                HttpStatus.NO_CONTENT
        ),HttpStatus.NO_CONTENT);
    }
}
