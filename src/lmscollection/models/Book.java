package lmscollection.models;

public class Book {
    private Long bookId;
    private String name;
    private String author;
    private Genre genre;

    public Book(Long id, String name, String author, Genre genre) {
        this.bookId = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Long getId() {
        return bookId;
    }

    public void setId(Long id) {
        this.bookId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
