package by.shabunya.eventmanager.service.impl;

import by.shabunya.eventmanager.entity.Event;
import by.shabunya.eventmanager.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public List<Event> getEventList() {
        return null;
    }

    @Override
    public Event getEventById(Long eventId) {
        return null;
    }

    @Override
    public Event saveEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event, Long eventId) {
        return null;
    }

    @Override
    public void deleteEvent(Long eventId) {

    }
}
