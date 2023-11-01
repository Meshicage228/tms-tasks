package thisProject.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import thisProject.example.domain.enums.JobTitle;

import javax.persistence.*;
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
    private String name;
    private String password;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private JobTitle title;
}
