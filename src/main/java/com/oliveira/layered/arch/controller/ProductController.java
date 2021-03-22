package com.oliveira.layered.arch.controller;

import com.oliveira.layered.arch.request.ProductRequest;
import com.oliveira.layered.arch.response.ProductResponse;
import com.oliveira.layered.arch.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/product"})
@Api(tags = "Product", description = "Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value = "List of products")
    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @ApiOperation(value = "Find a product")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {

        ProductResponse response = productService.findById(id);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "Create a product")
    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return productService.save(request);
    }

    @ApiOperation(value = "Update a product")
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody ProductRequest request) {

        ProductResponse response = productService.update(request, id);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "Delete a product")
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {

        productService.delete(id);

        return ResponseEntity.ok().build();
    }

}
