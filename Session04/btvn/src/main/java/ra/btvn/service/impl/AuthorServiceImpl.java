package ra.btvn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn.model.entity.Author;
import ra.btvn.model.dto.request.AuthorDTO;
import ra.btvn.repository.AuthorRepository;
import ra.btvn.service.AuthorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai author "+id));
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        authorRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai author "+id));
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai author "+id));
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor1(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Khong ton tai author " + id));
        if(authorDTO.getName()!=null &&  !authorDTO.getName().isBlank()){
            author.setName(authorDTO.getName());
        }
        if(authorDTO.getCountry()!=null && !authorDTO.getCountry().isBlank()){
            author.setCountry(authorDTO.getCountry());
        }
        return authorRepository.save(author);
    }
}
