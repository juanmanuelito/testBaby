package com.example.crud.domain.service;

import com.example.crud.domain.RabbitPublisher;
import com.example.crud.domain.entity.TestEntity;
import com.example.crud.domain.repository.TestRepository;
import com.example.crud.dto.Test;
import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TestService {

    private final ModelMapper    mapper;
    private final TestRepository  testRepository;
    private final RabbitPublisher rabbitPublisher;

    @Transactional
    public UUID create(Test test) {
        test.setId(UUID.randomUUID());
        TestEntity entity = testRepository.save(mapper.map(test, TestEntity.class));
        rabbitPublisher.publish(test);
        return entity.getId();
    }

    public void update(Test test) {
        if (test.getId() == null) {
            throw new InvalidParameterException("Id is required");
        }

        Optional<TestEntity> entity = testRepository.findById(test.getId());

        if (entity.isEmpty()) {
            throw new InvalidParameterException("Test not found");
        }

        testRepository.save(mapper.map(test, TestEntity.class));
    }

    public void delete(UUID id) {
        Optional<TestEntity> entity = testRepository.findById(id);

        if (entity.isEmpty()) {
            throw new InvalidParameterException("Test not found");
        }

        testRepository.deleteById(id);
    }

    public Test findById(UUID id) {
        return testRepository.findById(id)
            .map(test -> mapper.map(test, Test.class))
            .orElseThrow(() -> new InvalidParameterException("Test not found"));
    }
}
