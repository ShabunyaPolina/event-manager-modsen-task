package by.shabunya.eventmanager.dao.impl;

import by.shabunya.eventmanager.dao.GenericDAO;
import by.shabunya.eventmanager.entity.Event;
import by.shabunya.eventmanager.exception.EventNotFoundException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.function.Function;

@Repository
public class EventDAO implements GenericDAO<Event> {
    private final EntityManager entityManager;

    public EventDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Event> getAll() {
        return entityManager.createQuery("from Event", Event.class)
                .getResultList();
    }

    @Override
    public Event get(Long id) {
        Event event = entityManager.unwrap(Session.class).get(Event.class, id);
        if (event == null)
            throw new EventNotFoundException("No event with id " + id, id);
        return event;
    }

    @Override
    public void save(Event event) {
        entityManager.unwrap(Session.class).save(event);
    }

    @Override
    public void update(Event event, Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event eventToUpdate = session.get(Event.class, id);

        if (eventToUpdate == null)
            throw new EventNotFoundException("No event with id " + id, id);

        session.evict(eventToUpdate);
        eventToUpdate.setTheme(event.getTheme());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setOrganizer(event.getOrganizer());
        eventToUpdate.setTime(event.getTime());
        eventToUpdate.setVenue(event.getVenue());
        session.update(eventToUpdate);
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event eventToDelete = session.get(Event.class, id);

        if (eventToDelete == null)
            throw new EventNotFoundException("No event with id " + id, id);

        session.delete(eventToDelete);
    }

    public List<Event> getAll(String theme, String organizer, String date, String time) {
        if (theme == null && organizer == null && date == null && time == null)
            return getAll();

        String query = "SELECT e FROM Event e WHERE " +
                "(:eventTheme IS NULL OR e.theme = :eventTheme) " +
                "AND (:eventOrganizer IS NULL OR e.organizer = :eventOrganizer) " +
                "AND (cast(:eventDate AS date) IS NULL OR e.date = :eventDate)" +
                "AND (cast(:eventTime AS time) IS NULL OR e.time = :eventTime)";

        Function<String, Date> strToDate = Date::valueOf;
        Function<String, Time> strToTime = Time::valueOf;

        return entityManager.createQuery(query, Event.class)
                .setParameter("eventTheme", theme)
                .setParameter("eventOrganizer", organizer)
                .setParameter("eventDate", convertString(strToDate, date))
                .setParameter("eventTime", convertString(strToTime, time))
                .getResultList();
    }

    private <R> R convertString(Function<String, R> f, String value) {
        try {
            return value == null ? null : f.apply(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
