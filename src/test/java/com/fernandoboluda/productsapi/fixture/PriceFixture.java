package com.fernandoboluda.productsapi.fixture;

import com.fernandoboluda.productsapi.domain.entities.Price;

public class PriceFixture {

  public static Price createPrice(Integer price, Integer priceWithDiscount, Integer discount) {
    return Price.builder()
        .price(price)
        .priceWithDiscount(priceWithDiscount)
        .currency("EUR")
        .discountPercentage(discount)
        .build();
  }
}
