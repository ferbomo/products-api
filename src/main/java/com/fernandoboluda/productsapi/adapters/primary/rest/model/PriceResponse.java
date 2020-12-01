package com.fernandoboluda.productsapi.adapters.primary.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PriceResponse {

  private final String original;
  private final String finalPrice;
  private final String discountPercentage;
  private final String currency;
}

