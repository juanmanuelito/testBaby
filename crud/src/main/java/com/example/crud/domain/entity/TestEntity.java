package com.example.crud.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("TestEntity")
public class TestEntity {
    @Id
    private UUID          id;
    private String        name;
    private String        description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
