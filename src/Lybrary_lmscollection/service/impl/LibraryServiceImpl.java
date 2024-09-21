package Lybrary_lmscollection.service.impl;

import Lybrary_lmscollection.dao.LibraryDao;
import Lybrary_lmscollection.service.LibraryService;
import Lybrary_lmscollection.models.Library;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private final LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }


    @Override
    public List<Library> saveLibrary(List<Library> libraries) {

        return libraryDao.saveLibrary(libraries);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryDao.getAllLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        return libraryDao.getLibraryById(id);
    }

    @Override
    public Library updateLibrary(Long id, Library updatedLibrary) {
       return libraryDao.updateLibrary(id,updatedLibrary);

    }

    @Override
    public String deleteLibrary(Long id) {
       return libraryDao.deleteLibrary(id);

    }
}
