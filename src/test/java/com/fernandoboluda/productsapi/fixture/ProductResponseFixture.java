package com.fernandoboluda.productsapi.fixture;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;

public class ProductResponseFixture {

  public static ProductResponse createProductResponse(String sku, String name, String category,
      String original, String finalPrice, String discount) {
    return ProductResponse.builder()
        .sku(sku)
        .name(name)
        .category(category)
        .price(PriceResponseFixture.createPrice(original, finalPrice, discount))
        .build();
  }
}
