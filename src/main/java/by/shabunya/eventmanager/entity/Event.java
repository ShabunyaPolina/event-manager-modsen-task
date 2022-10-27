package by.shabunya.eventmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
