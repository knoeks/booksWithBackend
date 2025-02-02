package lt.techin.booksDB.service;

import lt.techin.booksDB.model.Book;
import lt.techin.booksDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  public Book findBookById(long id) {
    return bookRepository.findById(id).get();
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public List<Book> saveBooks(List<Book> books) {
    return bookRepository.saveAll(books);
  }

  public boolean existsBookById(long id) {
    return bookRepository.existsById(id);
  }
}
