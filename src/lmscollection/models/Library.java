package lmscollection.models;

import java.util.List;

public class Library {
    private Long libraryId;
    private String name;
    private String address;
    private List<Book> books;
    private List<Reader> readers;

    public Library(Long libraryId, String bayalinova, String sovetskaya) {
    }

    public Long getId() {
        return libraryId;
    }

    public void setId(Long id) {
        this.libraryId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public Library(Long libraryId, String name, String address, List<Book> books, List<Reader> readers) {

        this.libraryId= libraryId;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;


    }
}
