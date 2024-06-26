package com.spring.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@Getter
public class Instructor extends User {

    private String specialization;
    private String salary;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)

    private List<Batch> batch;

}
