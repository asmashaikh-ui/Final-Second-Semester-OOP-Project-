package service;

public interface InventoryOperations<T> {

    void add(T obj);
    void view();
    void update(int id, T obj);
    void delete(int id);
}