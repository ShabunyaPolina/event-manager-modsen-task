package by.shabunya.eventmanager.service.impl;

import by.shabunya.eventmanager.dao.impl.EventDAO;
import by.shabunya.eventmanager.entity.Event;
import by.shabunya.eventmanager.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventDAO eventDAO;

    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public List<Event> getEventList(String theme, String organizer, String date, String time) {
        return eventDAO.getAll(theme, organizer, date, time);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.get(eventId);
    }

    @Override
    public void saveEvent(Event event) {
        eventDAO.save(event);
    }

    @Override
    public void updateEvent(Event event, Long eventId) {
        eventDAO.update(event, eventId);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventDAO.delete(eventId);
    }
}
