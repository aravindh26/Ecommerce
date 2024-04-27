package com.spring.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity

public class Batch{

    @Id
    @GeneratedValue
    private UUID id;
    private String batchname;

    @ManyToOne

   // @JoinColumn(name = "instructor_id") // Assuming this is the column name in the Batch table
    private Instructor instructor;

}
