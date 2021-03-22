package com.oliveira.layered.arch.service.impl;

import com.oliveira.layered.arch.entity.ProductEntity;
import com.oliveira.layered.arch.exception.ProductNotFoundException;
import com.oliveira.layered.arch.repository.ProductRepository;
import com.oliveira.layered.arch.request.ProductRequest;
import com.oliveira.layered.arch.response.ProductResponse;
import com.oliveira.layered.arch.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<ProductEntity> optionalProduct = isProductExist(id);

        return this.convertToResponse(optionalProduct.get());
    }

    @Override
    public ProductResponse save(ProductRequest request) {

        ProductEntity productEntity = this.convertToEntity(request);

        return this.convertToResponse(productRepository.save(productEntity));
    }

    @Override
    public ProductResponse update(ProductRequest request, Long id) {
        isProductExist(id);

        ProductEntity entity = this.convertToEntity(request);
        entity.setId(id);

        return this.convertToResponse(productRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        isProductExist(id);

        productRepository.deleteById(id);
    }

    private Optional<ProductEntity> isProductExist(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) throw new ProductNotFoundException();

        return optionalProduct;
    }

    private ProductEntity convertToEntity(ProductRequest product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    private ProductResponse convertToResponse(ProductEntity product) {
        return modelMapper.map(product, ProductResponse.class);
    }

}
