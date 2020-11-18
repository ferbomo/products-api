package com.fernandoboluda.productsapi.domain.entities;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.fernandoboluda.productsapi.fixture.ProductFixture;
import org.junit.jupiter.api.Test;

class ProductTest {


  public static final Integer FINAL_PRICE = 11200;

  @Test
  void shouldCalculateDiscountProperly() {
    Product product = ProductFixture.createProduct("000001", "A product", "category1",
        "14000", "0", "20");

    Product result = product.applyDiscount(20);

    assertThat(result, is(notNullValue()));
    assertThat(result.getPrice().getPriceWithDiscount(), is(FINAL_PRICE));
  }

}