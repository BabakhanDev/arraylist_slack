package Lybrary_lmscollection.service.impl;

import Lybrary_lmscollection.dao.ReaderDao;
import Lybrary_lmscollection.service.ReaderService;
import Lybrary_lmscollection.models.Reader;
import java.util.List;

public class ReadServiceImpl implements ReaderService {
   private  final  ReaderDao readerDao;

    public ReadServiceImpl(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    @Override
    public void saveReader(Reader reader) {
       readerDao.saveReader(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerDao.getAllReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        return readerDao.getReaderById(id);

    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return readerDao.updateReader(id,reader);

    }
    public String deleteReader(Long id) {
        return readerDao.delete(id);
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        readerDao.assignReaderToLibrary(readerId,libraryId);

                }
            }
