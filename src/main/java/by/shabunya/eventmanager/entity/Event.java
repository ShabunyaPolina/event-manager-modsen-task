package by.shabunya.eventmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @NonNull
    @Column(name = "theme", nullable = false)
    private String theme;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @NonNull
    @Column(name = "organizer", nullable = false)
    private String organizer;

    @NonNull
    @Column(name = "date", nullable = false)
    private Date date;

    @NonNull
    @Column(name = "time", nullable = false)
    private Time time;

    @NonNull
    @Column(name = "venue", nullable = false)
    private String venue;
}
