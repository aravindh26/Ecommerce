package com.spring.Ecommerce.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Learner extends User {
    private String College;
    private String WorkExperience;

}
