package com.fernandoboluda.productsapi.adapters.primary.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {

  private String original;
  private String finalPrice;
  private String discountPercentage;
  private String currency;
}

