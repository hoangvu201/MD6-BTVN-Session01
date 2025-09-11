package ra.btvn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn.model.entity.Book;
import ra.btvn.repository.AuthorRepository;
import ra.btvn.repository.BookRepository;
import ra.btvn.service.AuthorService;
import ra.btvn.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong ton tai book "+id));
    }

    @Override
    public Book createBook(Book book, Long authorId) {
        authorService.getAuthorById(authorId);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book, Long authorId) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong ton tai book "+id));
        authorService.getAuthorById(authorId);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong ton tai book "+id));
        bookRepository.deleteById(id);
    }


    @Override
    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

    @Override
    public List<Book> findBooksByTitleAndAuthorName(String title, String authorName) {
        return bookRepository.findBooksByTitleAndAuthorName(title, authorName);
    }
}
