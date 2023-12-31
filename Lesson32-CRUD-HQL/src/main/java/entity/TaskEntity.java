package entity;


import domain.Readiness;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;
    private String nameOfTask;
    private String taskDescription;
    @Enumerated(value = EnumType.STRING)
    private Readiness readiness;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "tasks_id")
    PersonEntity person;
}
