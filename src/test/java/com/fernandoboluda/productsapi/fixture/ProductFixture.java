package com.fernandoboluda.productsapi.fixture;

import com.fernandoboluda.productsapi.domain.entities.Product;

public class ProductFixture {

  public static Product createProduct(String sku, String name, String category, String original,
      String finalPrice, String discount) {
    return Product.builder()
        .sku(sku)
        .name(name)
        .category(category)
        .price(PriceFixture.createPrice(Integer.parseInt(original), Integer.parseInt(finalPrice),
            Integer.parseInt(discount)))
        .build();
  }
}
