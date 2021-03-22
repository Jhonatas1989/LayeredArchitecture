package com.oliveira.layered.arch;

import com.oliveira.layered.arch.entity.ProductEntity;
import com.oliveira.layered.arch.request.ProductRequest;
import com.oliveira.layered.arch.response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConverterTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertEntityToResponse_thenCorrect() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1L);
        entity.setName("Product 1");
        entity.setCode(1L);

        ProductResponse response = modelMapper.map(entity, ProductResponse.class);
        assertEquals(entity.getId(), response.getId());
        assertEquals(entity.getName(), response.getName());
        assertEquals(entity.getCode(), response.getCode());
    }

    @Test
    public void whenConvertRequestToEntity_thenCorrect() {

        ProductRequest request = new ProductRequest();
        request.setName("Product 1");
        request.setCode(1L);

        ProductEntity entity = modelMapper.map(request, ProductEntity.class);
        assertEquals(entity.getId(), null);
        assertEquals(entity.getName(), request.getName());
        assertEquals(entity.getCode(), request.getCode());
    }

}
