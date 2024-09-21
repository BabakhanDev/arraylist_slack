package Lybrary_lmscollection.service.impl;

import Lybrary_lmscollection.dao.BookDao;
import Lybrary_lmscollection.service.BookService;
import Lybrary_lmscollection.models.Book;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
      return   bookDao.saveBook(libraryId,book);

    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return bookDao.getAllBooks(libraryId);
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return bookDao.getBookById(libraryId,bookId);
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
       bookDao.deleteBook(libraryId,bookId);
        return "Book deleted: ";
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        bookDao.clearBooksByLibraryId(libraryId);
            }
        }
