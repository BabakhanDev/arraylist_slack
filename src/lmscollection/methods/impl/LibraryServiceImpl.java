package lmscollection.methods.impl;

import lmscollection.methods.LibraryService;
import lmscollection.models.Library;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
private List<Library> libraries;
    public LibraryServiceImpl(List<Library> libraries) {
   this.libraries = libraries;
    }


    @Override
    public List<Library> saveLibrary(List<Library> newLibrary) {
        libraries.addAll(newLibrary);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : libraries) {
            if (library.getId().equals(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library updatedLibrary) {
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).getId().equals(id)) {
                libraries.set(i, updatedLibrary);
                return updatedLibrary;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        Library libraryToRemove = getLibraryById(id);
        if (libraryToRemove != null) {
            libraries.remove(libraryToRemove);
            return "Китепкана өчүрүлдү.";
        }
        return "Китепкана табылган жок.";
    }
}
