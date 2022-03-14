package com.piorini.productapi.controller;

import com.piorini.productapi.dto.ProductDTO;
import com.piorini.productapi.exception.ProductNotFoundException;
import com.piorini.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProduct() {

        return productService.getAll();
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(
            @PathVariable long categoryId
    ) {

        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/product/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier){
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(
            @Valid @RequestBody ProductDTO productDTO
    ) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/product/{id}")
    ProductDTO delete(@PathVariable Long id)
            throws ProductNotFoundException {
        return productService.delete(id);

    }


}
