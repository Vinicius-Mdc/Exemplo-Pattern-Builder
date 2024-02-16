package com.viniciusmdc.exemplopatternbuilder.controller;

import com.viniciusmdc.exemplopatternbuilder.dto.product.SimpleProductDTO;
import com.viniciusmdc.exemplopatternbuilder.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    List<Product> productsList = new ArrayList<>();

    @PostMapping("/basic")
    public ResponseEntity<String> createSimpleProduct(@RequestBody SimpleProductDTO p) {

        Product product = new Product.ProductBuilder(p.getName(), p.getDescription()).includeCategory("simpleProduct", p.getPrice()).build();
        productsList.add(product);

        return new ResponseEntity<>("Produto criado com sucesso!", HttpStatus.OK);
    }

}
