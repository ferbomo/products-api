package com.fernandoboluda.productsapi.adapters.secondary.json.repository;

import static java.util.Arrays.asList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandoboluda.productsapi.converters.ProductDtoToProductConverter;
import com.fernandoboluda.productsapi.domain.entities.Product;
import com.fernandoboluda.productsapi.adapters.secondary.json.repository.dto.ProductDto;
import com.fernandoboluda.productsapi.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

  private static final String JSON_FILE = "products.json";
  private final ProductDtoToProductConverter converter;

  @Override
  public List<Product> getAllProducts() {
    List<ProductDto> productDtoList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      productDtoList = asList(
          objectMapper.readValue(new ClassPathResource(JSON_FILE).getInputStream(), ProductDto[].class));
    } catch (IOException e) {
      log.error("Error retrieving products from json.", e);
    }
    return converter.convert(productDtoList);
  }
}
