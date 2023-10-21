package project.com.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator" ,strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    private String phone;

    @ManyToOne
    @ToString.Exclude
    private PersonEntity personEntity;
}
