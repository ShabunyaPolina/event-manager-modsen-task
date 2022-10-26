package by.shabunya.eventmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Long eventId;
    @NonNull
    private String theme;
    private String description;
    private String organizer;
    @NonNull
    private Date time;
    @NonNull
    private String venue;
}
