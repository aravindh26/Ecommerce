package com.spring.Ecommerce.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
public class InstructorDTO {
    private UUID id;
    private String name;
    private String email;
    private String specialization;
    private List<BatchDTO> batch;
}