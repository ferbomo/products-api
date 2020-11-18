package com.fernandoboluda.productsapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Price {

  private Integer price;
  private Integer priceWithDiscount;
  private Integer discountPercentage;
  private String currency;
}
