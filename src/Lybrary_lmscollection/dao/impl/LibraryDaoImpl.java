package Lybrary_lmscollection.dao.impl;

import Lybrary_lmscollection.dao.LibraryDao;
import Lybrary_lmscollection.dbl.Database;
import Lybrary_lmscollection.models.Library;

import java.util.List;

public class LibraryDaoImpl implements LibraryDao {
    private  final Database database;

    public LibraryDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
       database.getLibraries().addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
      return   database.getLibraries();

    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : database.getLibraries()) {
            if (library.getLibraryId().equals(id))
                return library;
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        Library libraryById = getLibraryById(id);
        if (libraryById != null){
            libraryById.setName(library.getName());
            libraryById.setAddress(library.getAddress());
            libraryById.setBooks(library.getBooks());
            libraryById.setReaders(library.getReaders());

    }
        return libraryById;
    }

    @Override
    public String deleteLibrary(Long id) {
        Library library = getLibraryById(id);
        if (library != null){
            database.getLibraries().remove(library);
            return "Library deleted successfully.";
        }
        return "Library not found.";
    }
}
