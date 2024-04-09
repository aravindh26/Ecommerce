package com.spring.Ecommerce.Controllers;

import com.spring.Ecommerce.Model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/Products/{productid}")
    public String getproduct(@PathVariable ("productid") int id) {
        String s = "helloForm" + id + "";
        return s; // Returns the name of the HTML form file
    }

    @PostMapping("Products/PostProduct")
    public String getRequestbody(@RequestBody Product product)
    {
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());


        String s = "ID is " + product.getId() + " and Name is " + product.getName() + "";
        return s;
    }


    }
