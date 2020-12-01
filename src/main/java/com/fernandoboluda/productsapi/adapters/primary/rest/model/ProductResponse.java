package com.fernandoboluda.productsapi.adapters.primary.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductResponse {

  private final String sku;
  private final String name;
  private final String category;
  private final PriceResponse price;
}
