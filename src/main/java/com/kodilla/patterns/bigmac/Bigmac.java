package com.kodilla.patterns.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        private static final List<String> ALLOWED_BUNS = List.of("with sesame", "without sesame");
        private static final List<String> ALLOWED_SAUCES = List.of("standard", "1000 islands", "barbecue");
        private static final List<String> ALLOWED_INGREDIENTS = List.of(
                "lettuce", "onion", "bacon", "cucumber", "chili", "mushrooms", "shrimps", "cheese"
        );

        public BigmacBuilder bun(String bun) {
            if (!ALLOWED_BUNS.contains(bun)) {
                throw new IllegalStateException("Bun must be 'with sesame' or 'without sesame'!");
            }
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1) {
                throw new IllegalStateException("Bigmac must have at least 1 burger!");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!ALLOWED_SAUCES.contains(sauce)) {
                throw new IllegalStateException("Sauce must be 'standard', '1000 islands', or 'barbecue'!");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!ALLOWED_INGREDIENTS.contains(ingredient)) {
                throw new IllegalStateException("Ingredient not available!");
            }
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
