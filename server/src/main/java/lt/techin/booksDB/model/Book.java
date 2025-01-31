package lt.techin.booksDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @NotBlank
  @Size(max = 60)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 30)
  private String author;

  @NotNull
  @NotBlank
  @Size(max = 30)
  private String category;

  @NotNull
  @Positive
  @Digits(integer = 4, fraction = 2)
  private BigDecimal price;

  @NotNull
  @NotBlank
  @Size(max = 80)
  private String cover;

  @NotNull
  private Boolean reserved;

  public Book(String title, String author, String category, BigDecimal price, String cover, Boolean reserved) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.price = price;
    this.cover = cover;
    this.reserved = reserved;
  }

  public Book() {

  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public Boolean getReserved() {
    return reserved;
  }

  public void setReserved(Boolean reserved) {
    this.reserved = reserved;
  }
}
