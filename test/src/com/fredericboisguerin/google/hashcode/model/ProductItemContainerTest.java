package com.fredericboisguerin.google.hashcode.model;

import com.fredericboisguerin.google.hashcode.model.ProductItem;
import com.fredericboisguerin.google.hashcode.model.ProductItemContainer;
import com.fredericboisguerin.google.hashcode.model.ProductType;
import com.fredericboisguerin.google.hashcode.model.Weight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductItemContainerTest {

    private static final ProductType PRODUCT_TYPE_A = new ProductType(new Weight(1));
    private static final ProductType PRODUCT_TYPE_B = new ProductType(new Weight(2));

    private ProductItemContainer productItemContainer;

    @Before
    public void setUp() throws Exception {
        productItemContainer = new ProductItemContainer();
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_IllegalStateException_when_unstore_on_empty_warehouse() throws Exception {
        productItemContainer.unload(PRODUCT_TYPE_A);
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_IllegalStateException_when_unstore_on_warehouse_without_product_of_required_type() throws Exception {
        ProductItem productItem = new ProductItem(PRODUCT_TYPE_B);
        productItemContainer.load(productItem);

        productItemContainer.unload(PRODUCT_TYPE_A);
    }

    @Test
    public void should_return_the_only_product_of_type_A_after_it_has_been_stored() throws Exception {
        ProductItem productItem = new ProductItem(PRODUCT_TYPE_A);
        productItemContainer.load(productItem);

        ProductItem unstoredProductItem = productItemContainer.unload(PRODUCT_TYPE_A);

        assertTrue(productItem == unstoredProductItem);
    }
}