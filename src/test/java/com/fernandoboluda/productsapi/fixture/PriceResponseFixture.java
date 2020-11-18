package com.fernandoboluda.productsapi.fixture;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.PriceResponse;

public class PriceResponseFixture {

  public static PriceResponse createPrice(String original, String finalPrice, String discount) {
    return PriceResponse.builder()
        .original(original)
        .finalPrice(finalPrice)
        .currency("EUR")
        .discountPercentage(discount)
        .build();
  }
}
