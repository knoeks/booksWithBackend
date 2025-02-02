package lt.techin.booksDB.controller;

import lt.techin.booksDB.model.Book;
import lt.techin.booksDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(bookService.findAllBooks());
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable long id) {
    if (!bookService.existsBookById(id)) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(bookService.findBookById(id));
  }

  @PostMapping("/book")
  public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    Book savedBook = bookService.saveBook(book);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedBook.getId())
                            .toUri()
            )
            .body(savedBook);
  }

  @PostMapping("/books")
  public ResponseEntity<List<Book>> saveBook(@RequestBody List<Book> books) {
    List<Book> savedBooks = bookService.saveBooks(books);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedBooks.getLast().getId())
                            .toUri()
            )
            .body(savedBooks);
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
    if (bookService.existsBookById(id)) {
      Book BookFromDb = bookService.findBookById(id);

      BookFromDb.setAuthor(book.getAuthor());
      BookFromDb.setCategory(book.getCategory());
      BookFromDb.setTitle(book.getTitle());
      BookFromDb.setCover(book.getCover());
      BookFromDb.setPrice(book.getPrice());
      BookFromDb.setReserved(book.getReserved());

      return ResponseEntity.ok(bookService.saveBook(BookFromDb));
    }

    Book savedBook = bookService.saveBook(book);

    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/api/books/{id}")
                    .buildAndExpand(savedBook.getId())
                    .toUri()
    ).body(savedBook);
  }
}
