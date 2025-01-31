package lt.techin.booksDB.repository;

import lt.techin.booksDB.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
