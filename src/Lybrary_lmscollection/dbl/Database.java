package Lybrary_lmscollection.dbl;

import Lybrary_lmscollection.models.Book;
import Lybrary_lmscollection.models.Library;
import Lybrary_lmscollection.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Library> libraries ;
    private List<Book> books ;
    private List<Reader> readers ;



    public Database(List<Library> libraries, List<Book> books, List<Reader> readers) {
        this.libraries = libraries;
        this.books = books;
        this.readers = readers;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
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
}
