package repositories;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();
    T findByID(int id);
    void saveToDB(T object);
    void deleteFromDB(T object);
    void deleteFromDB(int id);
    void updateDB(T object, int id);
}
