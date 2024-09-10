package lmscollection.methods.impl;

import lmscollection.methods.BookService;
import lmscollection.models.Book;
import lmscollection.models.Library;

import java.util.List;

import static lmscollection.models.GenerateId.libraryId;

public class BookServiceImpl implements BookService {
    private List<Library> libraries;

    public BookServiceImpl(List<Library> libraries) {
        this.libraries = libraries;
    }
    @Override
    public Book saveBook(Long libraryId, Book book) {

        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().add(book);
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                return library.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (book.getId().equals(bookId)) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                Book bookToRemove = getBookById(libraryId, bookId);
                if (bookToRemove != null) {
                    library.getBooks().remove(bookToRemove);
                    return "Китеп өчүрүлдү.";
                }
            }
        }
        return "Китеп табылган жок.";
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {

        for (Library library : libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().clear();
            }
        }
    }
}
