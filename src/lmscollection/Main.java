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

        Scanner scanner = new Scanner(System.in);
        List<Library> libraries = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();

        LibraryService libraryService = new LibraryServiceImpl(libraries);
        BookService bookService = new BookServiceImpl(libraries);
        ReaderService readerService = new ReadServiceImpl(readers, libraries);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Save Library");
            System.out.println("2. Get All Libraries");
            System.out.println("3. Get Library by ID");
            System.out.println("4. Update Library");
            System.out.println("5. Delete Library");
            System.out.println("6. Save Book");
            System.out.println("7. Get All Books by Library ID");
            System.out.println("8. Delete Book by Library ID");
            System.out.println("9. Clear Books by Library ID");
            System.out.println("10. Save Reader");
            System.out.println("11. Assign Reader to Library");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Library ID: ");
                    Long libraryId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Library name: ");
                    String libraryName = scanner.nextLine();
                    System.out.print("Enter Library address: ");
                    String libraryAddress = scanner.nextLine();
                    Library newLibrary = new Library(libraryId, libraryName, libraryAddress);
                    libraryService.saveLibrary(libraries, newLibrary);
                    System.out.println("Library saved!");
                    break;
                case 2:
                    System.out.println(libraryService.getAllLibraries(libraries));

                case 6:

                    // Save Book
                    System.out.print("Enter Library ID to add book: ");
                    Long libId = scanner.nextLong();
                    System.out.print("Enter Book ID: ");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter Author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter Genre (TECHNOLOGY,FICTION, NONFICTION, SCIENCE, FANTASY, HISTORY): ");
                    String genreInput = scanner.nextLine();
                    Genre genre = Genre.valueOf(genreInput.toUpperCase());
                    Book newBook = new Book(bookId, bookName, authorName, genre);
                    bookService.saveBook(libId, newBook);
                    System.out.println("Book saved!");
                    break;

                case 10:
                    // Save Reader
                    System.out.print("Enter Reader ID: ");
                    Long readerId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Reader full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Reader email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Reader phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Gender (MALE, FEMALE): ");
                    String genderInput = scanner.nextLine();
                    Gender gender = Gender.valueOf(genderInput.toUpperCase());
                    Reader newReader = new Reader(readerId, fullName, email, phoneNumber, gender);
                    readerService.saveReader(newReader);
                    System.out.println("Reader saved!");
                    break;

                case 11:
                    System.out.print("Enter Reader ID to assign: ");
                    Long assignReaderId = scanner.nextLong();
                    System.out.print("Enter Library ID to assign to: ");
                    Long assignLibraryId = scanner.nextLong();
                    readerService.assignReaderToLibrary(assignReaderId, assignLibraryId);
                    System.out.println("Reader assigned to library!");
                    break;

                case 0:
                    scanner.close();
                    return;
            }
        }
    }

    }

