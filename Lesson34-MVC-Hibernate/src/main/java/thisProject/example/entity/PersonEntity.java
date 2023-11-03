package thisProject.example.entity;


import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import thisProject.example.domain.enums.JobTitle;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

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
