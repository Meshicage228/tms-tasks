package entity;

import converters.SexConverter;
import domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import service.Dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;
    private String name;

    private LocalDate dateOfBirth;
    @Convert(converter = SexConverter.class)
    private Sex sex;

    @OneToMany(mappedBy = "person",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private List<TaskEntity> entityList;

    public void addTask(TaskEntity taskEntity) {
        if (entityList == null) {
            entityList = new ArrayList<>();
        }
        entityList.add(taskEntity);
        taskEntity.setPerson(this);

    }
}
