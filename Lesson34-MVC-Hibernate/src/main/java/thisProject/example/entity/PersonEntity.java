package thisProject.example.entity;


import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;
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
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue
    @GenericGenerator(name = "generic_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotBlank(message = "field is empty!")
    private String name;
    private String password;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private JobTitle title;

    @Temporal(value = TemporalType.TIME)
    private Date timeOfCreation;


}
