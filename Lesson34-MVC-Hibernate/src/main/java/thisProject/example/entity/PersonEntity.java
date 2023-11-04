package thisProject.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import thisProject.example.domain.enums.JobTitle;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "persons"/*, uniqueConstraints = @UniqueConstraint(name = "uniq_id", columnNames = "name"),
    indexes = @Index(unique = true, columnList = "user_id")*/)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private JobTitle title;

    @CreationTimestamp
    private Date timeOfCreation;

    @UpdateTimestamp
    private Date updated;

    @Version
    private Integer version;

}
