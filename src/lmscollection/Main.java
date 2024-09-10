package lmscollection;

import lmscollection.methods.BookService;
import lmscollection.methods.LibraryService;
import lmscollection.methods.ReaderService;
import lmscollection.methods.impl.BookServiceImpl;
import lmscollection.methods.impl.LibraryServiceImpl;
import lmscollection.methods.impl.ReadServiceImpl;
import lmscollection.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Library> libraries = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();

        LibraryService libraryService = new LibraryServiceImpl(libraries);
        BookService bookService = new BookServiceImpl(libraries);
        ReaderService readerService = new ReadServiceImpl(readers, libraries);

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
            System.out.println("16. Чыгуу");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Китепкана сактоо
                    System.out.print("Китепкана аты: ");
                    String libraryName = scanner.nextLine();
                    System.out.print("Китепкана дареги: ");
                    String libraryAddress = scanner.nextLine();
                    Library library = new Library((long) (libraries.size() + 1), libraryName, libraryAddress, new ArrayList<>(), new ArrayList<>());
                    libraries.add(library);
                    System.out.println("Китепкана сакталды: " + library);
                    break;

                case 2: // Бардык китепканаларды алуу
                    System.out.println("Бардык китепканалар:");
                    System.out.println(libraryService.getAllLibraries());
                    break;

                case 3: // Китепкана ID менен алуу
                    System.out.print("Китепкана ID: ");
                    Long libraryId = scanner.nextLong();
                    Library foundLibrary = libraryService.getLibraryById(libraryId);
                    if (foundLibrary != null) {
                        System.out.println("Табылган китепкана: " + foundLibrary);
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

                case 5: // Китепкана өчүрүү
                    System.out.print("Өчүрүү үчүн китепкана ID: ");
                    Long deleteLibraryId = scanner.nextLong();
                    String deleteMessage = libraryService.deleteLibrary(deleteLibraryId);
                    System.out.println(deleteMessage);
                    break;

                case 6: // Китеп сактоо
                    System.out.print("Кайсы китепканага (ID): ");
                    Long bookLibraryId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Китеп аты: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Китептин автору: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Китептин жанры (FICTION, NONFICTION, SCIENCE, FANTASY, HISTORY): ");
                    Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                    Book book = new Book((long) (libraries.size() + 1), bookName, bookAuthor, genre);
                    Book savedBook = bookService.saveBook(bookLibraryId, book);
                    if (savedBook != null) {
                        System.out.println("Китеп сакталды: " + savedBook);
                    } else {
                        System.out.println("Китепкана табылган жок.");
                    }
                    break;

                case 7: // Китептерди алуу (китепкана боюнча)
                    System.out.print("Кайсы китепканадан (ID): ");
                    Long getBooksLibraryId = scanner.nextLong();
                    List<Book> booksInLibrary = bookService.getAllBooks(getBooksLibraryId);
                    if (booksInLibrary != null) {
                        System.out.println("Китептер: " + booksInLibrary);
                    } else {
                        System.out.println("Китепкана табылган жок.");
                    }
                    break;

                case 8: // Китеп ID менен алуу
                    System.out.print("Кайсы китепкана (ID): ");
                    Long bookLibraryIdForGet = scanner.nextLong();
                    System.out.print("Китеп ID: ");
                    Long bookId = scanner.nextLong();
                    Book foundBook = bookService.getBookById(bookLibraryIdForGet, bookId);
                    if (foundBook != null) {
                        System.out.println("Табылган китеп: " + foundBook);
                    } else {
                        System.out.println("Китеп табылган жок.");
                    }
                    break;

                case 9: // Китеп өчүрүү
                    System.out.print("Кайсы китепкана (ID): ");
                    Long bookLibraryIdForDelete = scanner.nextLong();
                    System.out.print("Китеп ID: ");
                    Long bookIdForDelete = scanner.nextLong();
                    String deleteBookMessage = bookService.deleteBook(bookLibraryIdForDelete, bookIdForDelete);
                    System.out.println(deleteBookMessage);
                    break;

                case 10: // Китептерди өчүрүү (китепкана боюнча)
                    System.out.print("Кайсы китепканадан бардык китептерди өчүрүү (ID): ");
                    Long libraryIdToClearBooks = scanner.nextLong();
                    bookService.clearBooksByLibraryId(libraryIdToClearBooks);
                    System.out.println("Бардык китептер өчүрүлдү.");
                    break;

                case 11: // Окурман сактоо
                    System.out.print("Окурман аты-жөнү: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Окурмандын email: ");
                    String email = scanner.nextLine();
                    System.out.print("Окурмандын телефон номери: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Окурмандын жынысы (MALE, FEMALE, OTHER): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    Reader reader = new Reader((long) (readers.size() + 1), fullName, email, phoneNumber, gender);
                    readerService.saveReader(reader);
                    System.out.println("Окурман сакталды: " + reader);
                    break;

                case 12: // Бардык окурмандарды алуу
                    System.out.println("Бардык окурмандар:");
                    System.out.println(readerService.getAllReaders());
                    break;

                case 13: // Окурман ID менен алуу
                    System.out.print("Окурман ID: ");
                    Long readerId = scanner.nextLong();
                    Reader foundReader = readerService.getReaderById(readerId);
                    if (foundReader != null) {
                        System.out.println("Табылган окурман: " + foundReader);
                    } else {
                        System.out.println("Окурман табылган жок.");
                    }
                    break;

                case 14: // Окурман жаңыртуу
                    System.out.print("Жаңыртуучу окурман ID: ");
                    Long updateReaderId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Жаңы аты-жөнү: ");
                    String newFullName = scanner.nextLine();
                    System.out.print("Жаңы email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Жаңы телефон номери: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Жаңы жынысы (MALE, FEMALE, OTHER): ");
                    Gender newGender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    Reader updatedReader = new Reader(updateReaderId, newFullName, newEmail, newPhoneNumber, newGender);
                    Reader resultReader = readerService.updateReader(updateReaderId, updatedReader);
                    if (resultReader != null) {
                        System.out.println("Окурман жаңыртылды: " + resultReader);
                    } else {
                        System.out.println("Окурман табылган жок.");
                    }
                    break;

                case 15:
                    System.out.print("Окурман ID: ");
                    Long readerIdToAssign = scanner.nextLong();
                    System.out.print("Китепкана ID: ");
                    Long libraryIdToAssign = scanner.nextLong();
                    readerService.assignReaderToLibrary(readerIdToAssign, libraryIdToAssign);
                    System.out.println("Окурман китепканага бекитилди.");
                    break;

                case 16:
                    System.out.println("Программадан чыгуу.");
                    return;

                default:
                    System.out.println("Туура эмес тандоо. Кайрадан аракет кылыңыз.");
                    break;
            }
        }
    }
}


