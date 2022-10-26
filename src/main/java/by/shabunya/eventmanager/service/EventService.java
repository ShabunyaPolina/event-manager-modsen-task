package by.shabunya.eventmanager.service;

import by.shabunya.eventmanager.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEventList();

    Event getEventById(Long eventId);

    Event saveEvent(Event event);

    Event updateEvent(Event event, Long eventId);

    void deleteEvent(Long eventId);
}
