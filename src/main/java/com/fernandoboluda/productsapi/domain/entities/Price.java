package com.fernandoboluda.productsapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Price {

  private final Integer price;
  private final Integer priceWithDiscount;
  private final Integer discountPercentage;
  private final String currency;
}
