package com.example.lesson39springbootdatajpa.service.impl;

import com.example.lesson39springbootdatajpa.domain.enums.Genre;
import com.example.lesson39springbootdatajpa.dto.FilmDto;
import com.example.lesson39springbootdatajpa.dto.FilmSearchDto;
import com.example.lesson39springbootdatajpa.mappers.FilmMapper;
import com.example.lesson39springbootdatajpa.repository.FilmRepository;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.service.FilmService;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@RequiredArgsConstructor
@Getter
@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository repository;
    private final FilmMapper mapper;
    @Override
    public List<FilmEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public FilmEntity save(FilmEntity filmEntity) {
        return repository.save(filmEntity);
    }

    @Transactional
    public void updateRatingById(Float rating, Integer id) {
        repository.updateRatingById(rating, id);
    }
    public List<FilmDto> findAllOrderByRating(){
        return mapper.toDtos(repository.findAllOrderByRating());
    }
    public List<FilmEntity> findByCriteria(FilmSearchDto dto){
        return repository.findAll(createSpecification(dto));
    }
    Specification<FilmEntity> createSpecification(FilmSearchDto dto){
        return (root, query, builder) -> {
            String title = dto.getTitle();
            Float ratingTo = dto.getTo();
            Float ratingFrom = dto.getFrom();
            Genre genre = dto.getGenre();
            String dateOfCreation = dto.getDateOfCreation();

            var predicates = new ArrayList<Predicate>();

            if(isNotBlank(title)){
                predicates.add(builder.like(root.get("title"), "%" + title + "%"));
            }
            if(nonNull(ratingTo)){
                predicates.add(builder.le(root.get("rating"), ratingTo));
            }
            if(nonNull(ratingFrom)){
                predicates.add(builder.ge(root.get("rating"), ratingFrom));
            }
            if(nonNull(genre)){
                predicates.add(builder.equal(root.get("genre"), genre));
            }
            if(isNotBlank(dateOfCreation)){
                predicates.add(builder.equal(root.get("dateOfCreation"), dateOfCreation));
            }

            Predicate[] array = predicates.toArray(Predicate[]::new);

            return builder.and(array);
        };
    }

}
