package by.shabunya.eventmanager.dao.impl;

import by.shabunya.eventmanager.dao.EventDAO;
import by.shabunya.eventmanager.entity.Event;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    private final EntityManager entityManager;

    @Autowired
    public EventDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Event> get() {
        Session session = entityManager.unwrap(Session.class);
        Query<Event> query = session.createQuery("from Event", Event.class);
        return query.getResultList();
    }

    @Override
    public Event get(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    @Override
    public void save(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(event);
    }

    @Override
    public void update(Event event, Long id) {
        Session session = entityManager.unwrap(Session.class);
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event eventToDelete = session.get(Event.class, id);
        session.delete(eventToDelete);
    }
}
