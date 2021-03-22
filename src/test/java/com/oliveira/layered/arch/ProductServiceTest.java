package com.oliveira.layered.arch;

import com.oliveira.layered.arch.entity.ProductEntity;
import com.oliveira.layered.arch.repository.ProductRepository;
import com.oliveira.layered.arch.request.ProductRequest;
import com.oliveira.layered.arch.response.ProductResponse;
import com.oliveira.layered.arch.service.ProductService;
import com.oliveira.layered.arch.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ProductServiceTest {

    private ProductService service = new ProductServiceImpl();

    @Test
    public void whenFindAll_thenCorrect(@Mock ProductRepository repository) {

        List<ProductEntity> productsMock = new ArrayList<>();

        ProductEntity entity = new ProductEntity();
        entity.setId(1L);
        entity.setName("Product 1");
        entity.setCode(1L);

        productsMock.add(entity);

        Mockito.lenient().when(repository.findAll()).thenReturn(productsMock);

        List<ProductResponse> products = service.findAll();

        assertFalse(products.isEmpty());

    }


}
