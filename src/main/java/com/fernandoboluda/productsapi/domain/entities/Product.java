package com.fernandoboluda.productsapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {

  private final String sku;
  private final String name;
  private final String category;
  private final Price price;

  public Product applyDiscount(Integer discountToApply) {
    return Product.builder()
        .sku(this.sku)
        .name(this.name)
        .category(this.category)
        .price(Price.builder()
            .price(this.price.getPrice())
            .priceWithDiscount(this.price.getPrice() - calculateDiscount(discountToApply))
            .discountPercentage(discountToApply)
            .currency("EUR")
            .build())
        .build();
  }

  private int calculateDiscount(Integer discountToApply) {
    return this.price.getPrice() * discountToApply / 100;
  }
}
