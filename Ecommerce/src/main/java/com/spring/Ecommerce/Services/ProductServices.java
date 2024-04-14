package com.spring.Ecommerce.Services;

import com.spring.Ecommerce.DTO.ProductList;
import com.spring.Ecommerce.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    public List<ProductList> getproductbyid()
    {

        ProductList obj = new ProductList();


        String URL ="https://fakestoreapi.com/products";
        System.out.println(URL);

        RestTemplate callAPI  = new RestTemplate();

        Product[] Productobj = callAPI.getForObject(URL,Product[].class);

        System.out.println(Productobj);

        List<ProductList> List = new ArrayList<>();

        for(Product Product:Productobj)

        {
                List.add(ConverttoProductList(Product));
        }


        return List;
    }

    public ProductList ConverttoProductList(Product Product)
    {
        ProductList obj  = new ProductList();
        obj.setId(Product.getId());
        obj.setName(Product.getTitle());
        obj.setDescription(Product.getDescription());

        return obj;
    }

}
