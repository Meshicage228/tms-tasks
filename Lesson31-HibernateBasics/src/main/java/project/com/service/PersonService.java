package project.com.service;

import project.com.entity.PersonEntity;

import java.util.UUID;

public interface PersonService {
    PersonEntity getById(UUID uuid);
}
