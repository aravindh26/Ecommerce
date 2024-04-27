package com.spring.Ecommerce.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class CreateInstructorDTO {
    private String name;
    private String email;
    private String specialization;
    private List<BatchDTO> batch;
}