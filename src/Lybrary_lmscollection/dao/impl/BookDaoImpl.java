package Lybrary_lmscollection.dao.impl;


import Lybrary_lmscollection.dao.BookDao;
import Lybrary_lmscollection.dbl.Database;
import Lybrary_lmscollection.models.Book;
import Lybrary_lmscollection.models.Library;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final Database database;

    public BookDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        Library library = getLibraryById(libraryId);
        if (library != null) {
            library.getBooks().add(book);
            return book;
        }
        return null;
    }


    @Override
    public List<Book> getAllBooks(Long libraryId) {
        Library library = getLibraryById(libraryId);
        return library != null ? library.getBooks() : new ArrayList<>();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = getLibraryById(libraryId);
        if (library != null) {
            for (Book book : library.getBooks()) {
               if (book.getBookId().equals(bookId)){
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        Library library = getLibraryById(libraryId);
        if (library != null) {
            for (Book book : library.getBooks()) {
                if (book.getBookId().equals(bookId)){
                    library.getBooks().remove(book);
                    return "Book deleted successfully";
                }
            }
        }
        return  "Book not found";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        Library library = getLibraryById(libraryId);
        if (library != null) {
            library.getBooks().clear();
        }
    }

    private Library getLibraryById(Long libraryId) {
        for (Library library : database.getLibraries()) {
            if (library.getId().equals(libraryId)) {
                return library;
            }
        }
        return null; // Library not found
    }
}
