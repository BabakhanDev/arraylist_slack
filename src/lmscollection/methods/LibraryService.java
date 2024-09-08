package lmscollection.methods;

import lmscollection.models.Library;

import java.util.List;

public interface LibraryService {
    List<Library> saveLibrary(List<Library>libraries, Library newLibrary);
    List<Library>getAllLibraries(List<Library>libraries);
    Library getLibraryById(Long Id,List<Library>libraries);
    Library updateLibrary(Long id, List<Library> libraries);
    String deleteLibrary(Long id,List<Library>libraries);
}
