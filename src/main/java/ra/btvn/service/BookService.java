package ra.btvn.service;

import ra.btvn.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book, Long authorId);

    Book updateBook(Long id, Book book, Long authorId);

    void deleteBook(Long id);

    List<Book> getBooksByAuthor(Long authorId);

    List<Book> findBooksByTitleAndAuthorName(String title, String authorName);
}
