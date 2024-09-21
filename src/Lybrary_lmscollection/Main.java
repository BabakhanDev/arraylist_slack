package Lybrary_lmscollection;

import Lybrary_lmscollection.dao.BookDao;
import Lybrary_lmscollection.dao.LibraryDao;
import Lybrary_lmscollection.dao.ReaderDao;
import Lybrary_lmscollection.dao.impl.BookDaoImpl;
import Lybrary_lmscollection.dao.impl.LibraryDaoImpl;
import Lybrary_lmscollection.dao.impl.ReaderDaoImpl;
import Lybrary_lmscollection.dbl.Database;
import Lybrary_lmscollection.models.Book;
import Lybrary_lmscollection.models.Library;
import Lybrary_lmscollection.models.Reader;
import Lybrary_lmscollection.models.enums.Gender;
import Lybrary_lmscollection.models.enums.Genre;
import Lybrary_lmscollection.service.BookService;
import Lybrary_lmscollection.service.LibraryService;
import Lybrary_lmscollection.service.ReaderService;
import Lybrary_lmscollection.service.impl.BookServiceImpl;
import Lybrary_lmscollection.service.impl.LibraryServiceImpl;
import Lybrary_lmscollection.service.impl.ReadServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        LibraryDao libraryDao = new LibraryDaoImpl(database);
        BookDao bookDao = new BookDaoImpl(database);
        ReaderDao readerDao = new ReaderDaoImpl(database);


        LibraryService libraryService = new LibraryServiceImpl(libraryDao);
        BookService bookService = new BookServiceImpl(bookDao);
        ReaderService readerService = new ReadServiceImpl(readerDao);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Танданыз:");
            System.out.println("1. Китепкана сактоо");
            System.out.println("2. Бардык китепканаларды алуу");
            System.out.println("3. Китепкана ID аркылуу алуу");
            System.out.println("4. Китепкана жаңыртуу");
            System.out.println("5. Китепкана өчүрүү");
            System.out.println("6. Китеп сактоо");
            System.out.println("7. Китептерди алуу");
            System.out.println("8. Китеп ID аркылуу алуу");
            System.out.println("9. Китеп өчүрүү");
            System.out.println("10. Китептерди өчүрүү (библиотека ID)");
            System.out.println("11. Окурман сактоо");
            System.out.println("12. Бардык окурмандарды алуу");
            System.out.println("13. Окурман ID аркылуу алуу");
            System.out.println("14. Окурман жаңыртуу");
            System.out.println("15. Окурманды китепканага бекитүү");
            System.out.println("16. Окурманды ID номер Очуруу: ");
            System.out.println("17. Чыгуу");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Китепкана сактоо
                    System.out.println("Enter Library ID:");
                    Long libId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Китепкана аты: ");
                    String libraryName = scanner.nextLine();
                    System.out.print("Китепкана дареги: ");
                    String libraryAddress = scanner.nextLine();
                    Library library = new Library(libId, libraryName, libraryAddress, new ArrayList<>(), new ArrayList<>());
                    List<Library> libraries = new ArrayList<>();
                    libraries.add(library);
                    libraryService.saveLibrary(libraries);
                    System.out.println("Library saved.");
                    break;

                case 2: // Бардык китепканаларды алуу
                    System.out.println("Бардык китепканалар:");
                    List<Library> librar = libraryService.getAllLibraries();
                    for (Library libr : librar) {
                        System.out.println("ID: " + libr.getId());
                        System.out.println("Аты: " + libr.getName());
                        System.out.println("Дареги: " + libr.getAddress());
                        System.out.println("Китептер: " + libr.getBooks());
                        System.out.println("Окуучулар: " + libr.getReaders());
                        System.out.println("----------");
                    }
                    break;
                case 3: // Китепкана ID менен алуу
                    System.out.print("Китепкана ID: ");
                    Long libraryId = scanner.nextLong();
                    Library foundLibrary = libraryService.getLibraryById(libraryId);
                    if (foundLibrary != null) {
                        System.out.println("Табылган китепкана: " + foundLibrary.getName()+ ", Address: " + foundLibrary.getAddress());
                    } else {
                        System.out.println("Китепкана табылган жок.");
                    }
                    break;

                case 4: // Китепкана жаңыртуу
                    System.out.print("Жаңыртуучу китепкана ID: ");
                    Long updateLibraryId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Жаңы китепкана аты: ");
                    String newLibraryName = scanner.nextLine();
                    System.out.print("Жаңы китепкана дареги: ");
                    String newLibraryAddress = scanner.nextLine();
                    Library updatedLibrary = new Library(updateLibraryId, newLibraryName, newLibraryAddress, new ArrayList<>(), new ArrayList<>());
                    Library result = libraryService.updateLibrary(updateLibraryId, updatedLibrary);
                    if (result != null) {
                        System.out.println("Китепкана жаңыртылды: " + result);
                    } else {
                        System.out.println("Китепкана табылган жок.");
                    }
                    break;
//
                case 5: // Китепкана өчүрүү
                    System.out.print("Өчүрүү үчүн китепкана ID: ");
                    Long deleteLibraryId = scanner.nextLong();
                    String deleteMessage = libraryService.deleteLibrary(deleteLibraryId);
                    System.out.println(deleteMessage);
                    break;

                case 6: // Китеп сактоо
                    System.out.print("Кайсы китепканага (ID): ");
                    Long saveLibraryId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Enter Book ID:");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Китеп аты: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Китептин автору: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Китептин жанры (FICTION, NONFICTION, SCIENCE, FANTASY, HISTORY): ");
                    Genre bookGenre = Genre.valueOf(scanner.nextLine().toUpperCase());

                    Book book = new Book(bookId, bookName, bookAuthor, bookGenre);
                    bookService.saveBook(saveLibraryId, book);
                    System.out.println("Китеп сакталды: ");
                    break;

                case 7: // Китептерди алуу (китепкана боюнча)
                    System.out.print("Кайсы китепканадан (ID): ");
                    Long allBooksLibId = scanner.nextLong();
                    List<Book> allBooks = bookService.getAllBooks(allBooksLibId);
                    allBooks.forEach(bk -> System.out.println(bk.getName() + " by " + bk.getAuthor()));
                    break;

                case 8: // Китеп ID менен алуу
                    System.out.print("Кайсы китепкана (ID): ");
                    Long getBookLibId = scanner.nextLong();

                    System.out.println("Enter Book ID:");
                    Long bookIdToGet = scanner.nextLong();
                    Book foundBook = bookService.getBookById(getBookLibId, bookIdToGet);
                    if (foundBook != null) {
                        System.out.println("Book: " + foundBook.getName() + " by " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;


                case 9: // Китеп өчүрүү
                    System.out.print("Кайсы китепкана (ID): ");
                    Long deleteBookLibId = scanner.nextLong();

                    System.out.println("Enter Book ID to delete:");
                    Long bookIdToDelete = scanner.nextLong();
                    String deleteBookMessage = bookService.deleteBook(deleteBookLibId, bookIdToDelete);
                    System.out.println(deleteBookMessage);
                    break;


                case 10: // Китептерди өчүрүү (китепкана боюнча)
                    System.out.print("Кайсы китепканадан бардык китептерди өчүрүү (ID): ");
                    Long clearLibId = scanner.nextLong();
                    bookService.clearBooksByLibraryId(clearLibId);
                    System.out.println("All books cleared from the library.");
                    break;

                case 11: // Окурман сактоо
                    System.out.println("Enter Reader ID:");
                    Long readerId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Окурман аты-жөнү: ");
                    String readerFullName = scanner.nextLine();
                    System.out.print("Окурмандын email: ");
                    String readerEmail = scanner.nextLine();
                    System.out.print("Окурмандын телефон номери: ");
                    String readerPhoneNumber = scanner.nextLine();
                    System.out.print("Окурмандын жынысы (MALE, FEMALE, OTHER): ");
                    Gender readerGender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    Reader reader = new Reader(readerId, readerFullName, readerEmail, readerPhoneNumber, readerGender);
                    readerService.saveReader(reader);
                    System.out.println("Reader saved.");
                    break;

                case 12: // Бардык окурмандарды алуу
                    System.out.println("Бардык окурмандар:");
                    List<Reader> allReaders = readerService.getAllReaders();
                    for (Reader read : allReaders) {
                        System.out.println("Аты-жөнү: " + read.getFullName());
                        System.out.println("Email: " + read.getEmail());
                        System.out.println("Телефон номер: " + read.getPhoneNumber());
                        System.out.println("Жынысы: " + read.getGender());
                        System.out.println("----------");
                    }
                    break;

                case 13: // Окурман ID менен алуу
                    System.out.print("Окурман ID: ");
                    Long readerIdToGet = scanner.nextLong();
                    Reader foundReader = readerService.getReaderById(readerIdToGet);
                    if (foundReader != null) {
                        System.out.println("Reader: " + foundReader.getFullName() + ", Email: " + foundReader.getEmail());
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 14: // Окурман жаңыртуу
                    System.out.print("Жаңыртуучу окурман ID: ");
                    Long updateReaderId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Жаңы аты-жөнү: ");
                    String updateReaderName = scanner.nextLine();
                    System.out.print("Жаңы email: ");
                    String updateReaderEmail = scanner.nextLine();
                    System.out.print("Жаңы телефон номери: ");
                    String updateReaderPhone = scanner.nextLine();
                    System.out.print("Жаңы жынысы (MALE, FEMALE, OTHER): ");
                    Gender updateReaderGender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    Reader updateReader = new Reader(updateReaderId, updateReaderName, updateReaderEmail, updateReaderPhone, updateReaderGender);
                    Reader updatedReader = readerService.updateReader(updateReaderId, updateReader);
                    if (updatedReader != null) {
                        System.out.println("Reader updated."+updatedReader);
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 15:
                    System.out.print("Окурман ID: ");
                    Long assignReaderId = scanner.nextLong();

                    System.out.print("Китепкана ID: ");
                    Long assignLibraryId = scanner.nextLong();
                    readerService.assignReaderToLibrary(assignReaderId, assignLibraryId);
                    System.out.println("Reader assigned to the library.");
                    break;

                case 16: // Окурманды өчүрүү
                    System.out.print("Өчүрүлө турган окурмандын ID номерин киргизиңиз: ");
                    Long readerIdToDelete = scanner.nextLong();
                    String deleteMess = readerService.deleteReader(readerIdToDelete);
                    System.out.println(deleteMess);
                    break;
                case 17:
                    System.out.println("Программадан чыгуу.");
                    return;

                default:
                    System.out.println("Туура эмес тандоо. Кайрадан аракет кылыңыз.");
                    break;
            }
        }
    }
}


