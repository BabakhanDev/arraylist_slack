package Lybrary_lmscollection.models;

public class GenerateId {
    public static Long libraryId = 0L;
    public  static Long bookId = 0L;
    public static Long readerId = 0L;

    public static Long genLibrary(){
        return ++libraryId;
    }
    public static Long genBook(){
        return ++bookId;
    }
    public static Long genReader(){
        return ++readerId;
    }
}
