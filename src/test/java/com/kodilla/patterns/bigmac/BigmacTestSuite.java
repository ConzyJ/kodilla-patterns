package com.kodilla.patterns.bigmac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("cheese")
                .ingredient("bacon")
                .build();

        System.out.println(bigmac);

        // When
        int howManyIngredients = bigmac.getIngredients().size();

        // Then
        assertEquals("with sesame", bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("barbecue", bigmac.getSauce());
        assertEquals(3, howManyIngredients);
        assertTrue(bigmac.getIngredients().contains("bacon"));
    }

    @Test
    void testBigmacBuilder_InvalidBun() {
        // Given / When / Then
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Bigmac.BigmacBuilder().bun("garlic bread")
        );

        assertEquals("Bun must be 'with sesame' or 'without sesame'!", exception.getMessage());
    }

    @Test
    void testBigmacBuilder_InvalidSauce() {
        // Given / When / Then
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Bigmac.BigmacBuilder().sauce("chocolate")
        );

        assertEquals("Sauce must be 'standard', '1000 islands', or 'barbecue'!", exception.getMessage());
    }

    @Test
    void testBigmacBuilder_InvalidIngredient() {
        // Given / When / Then
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Bigmac.BigmacBuilder().ingredient("pineapple")
        );

        assertEquals("Ingredient not available!", exception.getMessage());
    }
}
