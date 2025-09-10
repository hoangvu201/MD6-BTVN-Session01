package ra.btvn.service;

import ra.btvn.model.entity.Author;
import ra.btvn.model.dto.request.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);

    Author updateAuthor1(Long id, AuthorDTO authorDTO);
}
