package com.piorini.productapi.service;

import com.piorini.productapi.dto.ProductDTO;
import com.piorini.productapi.model.Product;
import com.piorini.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }
}
