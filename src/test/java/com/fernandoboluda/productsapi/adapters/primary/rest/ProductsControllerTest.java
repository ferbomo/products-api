package com.fernandoboluda.productsapi.adapters.primary.rest;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;
import com.fernandoboluda.productsapi.fixture.ProductResponseFixture;
import com.fernandoboluda.productsapi.ports.primary.ProductApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

  public static final String EMPTY_STRING = "";
  public static final String CATEGORY_1 = "Category 1";
  @Mock
  private ProductApplication productApplication;
  @InjectMocks
  private ProductsController productsController;

  @Test
  void shouldReturnProducts() {
    List<ProductResponse> productResponse = createProductResponseList();
    when(productApplication.getAllProducts(EMPTY_STRING, EMPTY_STRING)).thenReturn(productResponse);

    ResponseEntity<List<ProductResponse>> response = productsController
        .getAllProducts(Optional.empty(), Optional.empty());

    verify(productApplication, times(1)).getAllProducts(EMPTY_STRING, EMPTY_STRING);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody(), is(notNullValue()));
    assertThat(response.getBody().size(), is(2));
  }

  @Test
  void shouldReturnProductsFilteredByCategory() {
    List<ProductResponse> productResponse = createProductResponseListFilteredByCategory();
    when(productApplication.getAllProducts(CATEGORY_1, EMPTY_STRING)).thenReturn(productResponse);

    ResponseEntity<List<ProductResponse>> response = productsController
        .getAllProducts(Optional.of(CATEGORY_1), Optional.empty());

    verify(productApplication, times(1)).getAllProducts(CATEGORY_1, EMPTY_STRING);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody(), is(notNullValue()));
    assertThat(response.getBody().size(), is(1));
  }

  private List<ProductResponse> createProductResponseList() {
    return asList(ProductResponseFixture
            .createProductResponse("000001", "A product", CATEGORY_1,
                "14000", "11200", "20"),
        ProductResponseFixture.createProductResponse("000002", "Another product",
            "Category 2", "29000", "24650", "15"));
  }

  private List<ProductResponse> createProductResponseListFilteredByCategory() {
    return singletonList(ProductResponseFixture
        .createProductResponse("000001", "A product", CATEGORY_1,
            "14000", "11200", "20"));
  }

}