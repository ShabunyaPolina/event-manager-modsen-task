package by.shabunya.eventmanager.dao;

import by.shabunya.eventmanager.entity.Event;

import java.util.List;

public interface EventDAO {
    List<Event> get();

    Event get(Long id);

    void save(Event event);

    void update(Event event, Long id);

    void delete(Long id);
}
