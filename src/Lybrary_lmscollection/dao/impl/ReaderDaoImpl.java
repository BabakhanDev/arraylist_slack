package Lybrary_lmscollection.dao.impl;

import Lybrary_lmscollection.dao.ReaderDao;
import Lybrary_lmscollection.dbl.Database;
import Lybrary_lmscollection.models.Library;
import Lybrary_lmscollection.models.Reader;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    private final Database database;

    public ReaderDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveReader(Reader reader) {
        database.getReaders().add(reader);

    }

    @Override
    public List<Reader> getAllReaders() {
        return database.getReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : database.getReaders()) {
            if (reader.getReaderId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader databaseReader : database.getReaders()) {
            if (reader.getReaderId().equals(id)){
              databaseReader.setFullName(reader.getFullName());
                databaseReader.setEmail(reader.getEmail());
                databaseReader.setPhoneNumber(reader.getPhoneNumber());
                databaseReader.setGender(reader.getGender());
                return databaseReader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        Library library = getLibraryById(libraryId);
        if (reader != null && library != null){
            library.getReaders().add(reader);
        }

    }

    @Override
    public String delete(Long id) {
        List<Reader> readers = database.getReaders();
        for (Reader reader : readers) {
            if (reader.getReaderId().equals(id)){
                readers.remove(reader);
                return "Окурман ийгиликтүү өчүрүлдү";
            }
        }
        return "Окурман табылган жок";
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
