package project.com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import project.com.converters.SexConverter;
import project.com.domain.JobTitle;
import project.com.domain.Sex;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "Person")
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(generator = "uuidGenerator" )
    @GenericGenerator( name = "uuidGenerator",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @Convert(converter = SexConverter.class)
    private Sex sex;

    @Column(length = 1024)
    private String someInfo;

    @Enumerated(value = EnumType.STRING)
    private JobTitle jobTitle;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "personEntity")
    private List<PhoneEntity> phones;
}
