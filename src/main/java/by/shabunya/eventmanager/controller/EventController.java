package by.shabunya.eventmanager.controller;

import by.shabunya.eventmanager.entity.Event;
import by.shabunya.eventmanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEventList(
            @RequestParam(value = "theme", required = false) String theme,
            @RequestParam(value = "organizer", required = false) String organizer,
            @RequestParam(value = "time", required = false) String time) {
        return eventService.getEventList(theme, organizer, time);
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable("id") Long eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping("/events")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveEvent(@Valid @RequestBody Event event) {
        eventService.saveEvent(event);
    }

    @PutMapping("/events/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateEvent(@RequestBody Event event,
                            @PathVariable("id") Long eventId) {
        eventService.updateEvent(event, eventId);
    }

    @DeleteMapping("/events/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteEvent(@PathVariable("id") Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
