package by.shabunya.eventmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
    @Column(name = "time", nullable = false)
    private Date time;

    @NonNull
    @Column(name = "venue", nullable = false)
    private String venue;
}
