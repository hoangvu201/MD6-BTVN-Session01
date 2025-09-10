package ra.btvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.btvn.model.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Id(Long authorId);

    List<Book> findAllByTitleContainsOrAuthor_Id(String title, Long authorId);

    @Query("select b from Book b where b.title like concat('%',:title,'%') or b.author.name like concat('%',:authorName,'%')")
    List<Book> findBooksByTitleAndAuthorName(String title, String authorName);
}
