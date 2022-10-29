package by.shabunya.eventmanager.dao;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();

    T get(Long id);

    void save(T entity);

    void update(T entity, Long id);

    void delete(Long id);
}
