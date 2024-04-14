package com.spring.Ecommerce.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Product {

    private int id;
    private  String title;
    private String Description;
    private String ImageURL;
    private String Category;
    private String Title;
}
