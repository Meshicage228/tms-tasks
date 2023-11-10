package com.example.lesson39springbootdatajpa.entity;

import com.example.lesson39springbootdatajpa.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "films")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private String dateOfCreation;

    private Float rating;

    @CreationTimestamp
    private Date timeOfCreation;

    @UpdateTimestamp
    private Date updateTime;

    @Version
    private Integer version;

}
