package com.spring.Ecommerce.Controllers;

import com.spring.Ecommerce.DTO.ProductList;
import com.spring.Ecommerce.Model.Product;
import com.spring.Ecommerce.Services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Generates Details pertaining to the products available//
@RestController
public class ProductController {


private ProductServices productservice;

    public ProductController(ProductServices productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/Products/{productid}")
    public String getproduct(@PathVariable ("productid") int id) {
        String s = "helloForm" + id + "";
        return s; // Returns the name of the HTML form file
    }

    @PostMapping("Products/PostProduct")
    public String getRequestbody(@RequestBody Product product)
    {
        System.out.println(product.getId());
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());


        String s = "ID is " + product.getId() + " and Name is " + product.getTitle() + "";
        return s;
    }

    @GetMapping("Products/GetProductDetails")
    public @ResponseBody List<ProductList> getAllProducts()
    {

        return productservice.getproductbyid();
    }




    }
