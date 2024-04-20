package com.spring.Ecommerce.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateUserDTO {

    private String id;
    private String name;
    private String email;
    private String Status;
}
