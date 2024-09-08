package lmscollection.methods.impl;

import lmscollection.methods.LibraryService;
import lmscollection.models.Library;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    public LibraryServiceImpl(List<Library> libraries) {
    }


    @Override
    public List<Library> saveLibrary(List<Library> libraries, Library newLibrary) {
        libraries.add(newLibrary);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries(List<Library> libraries) {
        return libraries ;
    }




    @Override
    public Library getLibraryById(Long id,List<Library>libraries) {
        for (Library library : libraries) {
            if (library.getId().equals(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, List<Library> libraries) {
        for (Library lib : libraries) {
            if (lib.getId().equals(id)) {
                libraries.remove(lib);
                libraries.add(lib);
                return lib ;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id,List<Library>libraries) {
        for (Library library : libraries) {
            if (library.getId().equals(id)){
                libraries.remove(library);
                return "library deleted";
            }
        }

        return "Library not found";
    }
}
