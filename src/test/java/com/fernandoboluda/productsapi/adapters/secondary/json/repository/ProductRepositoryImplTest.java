package com.fernandoboluda.productsapi.adapters.secondary.json.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.fernandoboluda.productsapi.converters.ProductDtoToProductConverter;
import com.fernandoboluda.productsapi.domain.entities.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {

  @Spy
  private ProductDtoToProductConverter converter;
  @InjectMocks
  private ProductRepositoryImpl repository;

  @Test
  void shouldReturnProducts(){

    List<Product> products = repository.getAllProducts();

    assertThat(products, is(notNullValue()));
    assertThat(products.size(), is(5));
  }

}