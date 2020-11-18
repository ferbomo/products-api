package com.fernandoboluda.productsapi.converters;

import static java.util.stream.Collectors.toList;

import com.fernandoboluda.productsapi.adapters.secondary.json.repository.dto.ProductDto;
import com.fernandoboluda.productsapi.domain.entities.Price;
import com.fernandoboluda.productsapi.domain.entities.Product;

import java.util.List;

public class ProductDtoToProductConverter {

  public List<Product> convert(List<ProductDto> productDtoList) {
    return productDtoList.stream()
        .map(this::convert)
        .collect(toList());
  }

  private Product convert(ProductDto productDto) {
    return Product.builder()
        .sku(productDto.getSku())
        .name(productDto.getName())
        .category(productDto.getCategory())
        .price(Price.builder()
            .price(productDto.getPrice())
            .build())
        .build();
  }
}
