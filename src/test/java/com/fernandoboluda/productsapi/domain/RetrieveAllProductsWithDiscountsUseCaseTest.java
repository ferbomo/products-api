package com.fernandoboluda.productsapi.domain;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;
import com.fernandoboluda.productsapi.converters.ProductToProductResponseConverter;
import com.fernandoboluda.productsapi.domain.entities.Product;
import com.fernandoboluda.productsapi.domain.service.DiscountsService;
import com.fernandoboluda.productsapi.fixture.ProductFixture;
import com.fernandoboluda.productsapi.fixture.ProductResponseFixture;
import com.fernandoboluda.productsapi.ports.secondary.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RetrieveAllProductsWithDiscountsUseCaseTest {

  private static final String CATEGORY_1 = "Category 1";
  public static final String PRICE_LESS_THAN = "28000";
  @Mock
  private ProductRepository repository;
  @Mock
  private DiscountsService discountsService;
  @Mock
  private ProductToProductResponseConverter converter;
  @InjectMocks
  private RetrieveAllProductsWithDiscountsUseCase useCase;

  @Test
  void shouldGetAllProducts() {
    Product product1 = ProductFixture.createProduct("000001", "A product", CATEGORY_1,
        "14000", "11200", "20");
    Product product2 = ProductFixture.createProduct("000002", "Another product",
        "Category 2", "29000", "24650", "15");
    List<Product> productList = asList(product1, product2);
    when(repository.getAllProducts()).thenReturn(productList);
    when(discountsService.applyDiscounts(product1)).thenAnswer(i -> i.getArguments()[0]);
    when(discountsService.applyDiscounts(product2)).thenAnswer(i -> i.getArguments()[0]);
    when(converter.convert(productList)).thenReturn(createProductResponseList());

    List<ProductResponse> result = useCase.getAllProducts("", "");

    verify(repository, times(1)).getAllProducts();
    verify(discountsService, times(2)).applyDiscounts(any());
    verify(converter, times(1)).convert(anyList());
    assertThat(result, is(notNullValue()));
    assertThat(result.size(), is(2));
  }

  @Test
  void shouldGetAllProductsFiltered() {
    Product product1 = ProductFixture.createProduct("000001", "A product", CATEGORY_1,
        "14000", "11200", "20");
    Product product2 = ProductFixture.createProduct("000002", "Another product",
        "Category 2", "29000", "24650", "15");
    List<Product> productList = asList(product1, product2);
    when(repository.getAllProducts()).thenReturn(productList);
    when(discountsService.applyDiscounts(product1)).thenAnswer(i -> i.getArguments()[0]);
    when(converter.convert(singletonList(product1))).thenReturn(createProductResponseListFiltered());

    List<ProductResponse> result = useCase.getAllProducts(CATEGORY_1, PRICE_LESS_THAN);

    verify(repository, times(1)).getAllProducts();
    verify(discountsService, times(1)).applyDiscounts(any());
    verify(converter, times(1)).convert(anyList());
    assertThat(result, is(notNullValue()));
    assertThat(result.size(), is(1));
  }

  private List<ProductResponse> createProductResponseList() {
    return asList(ProductResponseFixture
            .createProductResponse("000001", "A product", CATEGORY_1,
                "14000", "11200", "20"),
        ProductResponseFixture.createProductResponse("000002", "Another product",
            "Category 2", "29000", "24650", "15"));
  }

  private List<ProductResponse> createProductResponseListFiltered() {
    return singletonList(ProductResponseFixture
            .createProductResponse("000001", "A product", CATEGORY_1,
                "14000", "11200", "20"));
  }

}