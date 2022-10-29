package by.shabunya.eventmanager.exception;

public class EventNotFoundException extends RuntimeException {

    private final String message;
    private final Long eventId;

    public EventNotFoundException(String message, Long eventId) {
        this.message = message;
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
