package lmscollection.methods.impl;

import lmscollection.methods.ReaderService;
import lmscollection.models.Library;
import lmscollection.models.Reader;

import java.util.List;

public class ReadServiceImpl implements ReaderService {
    private List<Reader> readers;
    private List<Library> libraries;

    public ReadServiceImpl(List<Reader> readers, List<Library> libraries) {
    }

    public void ReaderServiceImpl(List<Reader> readers, List<Library> libraries) {
        this.readers = readers;
        this.libraries = libraries;
    }

    @Override
    public void saveReader(Reader reader) {
        readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : readers) {
            if (reader.getReaderId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getReaderId().equals(id)) {
                readers.set(i, reader);
                return reader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        if (reader != null) {
            for (Library library : libraries) {
                if (library.getId().equals(libraryId)) {
                    library.getReaders().add(reader);
                    break;
                }
            }
        }
    }
}
