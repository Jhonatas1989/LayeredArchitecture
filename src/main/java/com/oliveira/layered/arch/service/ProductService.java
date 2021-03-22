package com.oliveira.layered.arch.service;

import com.oliveira.layered.arch.request.ProductRequest;
import com.oliveira.layered.arch.response.ProductResponse;

import java.util.List;

public interface ProductService {

    public List<ProductResponse> findAll();

    public ProductResponse findById(Long id);

    public ProductResponse save(ProductRequest request);

    public ProductResponse update(ProductRequest request, Long id);

    public void delete(Long id);

}
