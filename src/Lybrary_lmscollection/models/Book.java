package Lybrary_lmscollection.models;

import Lybrary_lmscollection.models.enums.Genre;

import java.util.List;

public class Book  {
    private Long bookId;
    private String name;
    private String author;
    private Genre genre;

    public Book(Long bookId, String name, String author, Genre genre) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "\nBook{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
