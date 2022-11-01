package by.shabunya.eventmanager.service;

import by.shabunya.eventmanager.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEventList(String theme, String organizer, String date, String time);

    Event getEventById(Long eventId);

    void saveEvent(Event event);

    void updateEvent(Event event, Long eventId);

    void deleteEvent(Long eventId);
}
