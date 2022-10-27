package by.shabunya.eventmanager.service;

import by.shabunya.eventmanager.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEventList();

    Event getEventById(Long eventId);

    void saveEvent(Event event);

    void updateEvent(Event event, Long eventId);

    void deleteEvent(Long eventId);
}
