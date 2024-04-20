package com.spring.Ecommerce.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static java.awt.font.TransformAttribute.IDENTITY;


@Getter
@Setter
@Entity(name = "Ecomm_User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(name = "email_address", unique = true)
    public String email;

}
