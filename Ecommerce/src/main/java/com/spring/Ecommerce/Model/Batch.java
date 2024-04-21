package com.spring.Ecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Batch{

    @Id
    private Long id;
    private String batchno;

    @ManyToOne
   // @JoinColumn(name = "instructor_id") // Assuming this is the column name in the Batch table
    private Instructor instructor;

}
