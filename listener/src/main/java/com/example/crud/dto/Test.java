package com.example.crud.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Test implements Serializable {
    private UUID          id;
    private String        name;
    private String        description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
