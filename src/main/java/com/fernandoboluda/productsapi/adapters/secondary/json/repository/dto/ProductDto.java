package com.fernandoboluda.productsapi.adapters.secondary.json.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

  private String sku;
  private String name;
  private String category;
  private Integer price;
}
