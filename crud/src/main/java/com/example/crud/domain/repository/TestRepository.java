package com.example.crud.domain.repository;

import com.example.crud.domain.entity.TestEntity;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<TestEntity, UUID> {
}
