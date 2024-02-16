package com.viniciusmdc.exemplopatternbuilder.entity;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private String name;
    private String description;
    private String imageUrl;
    private Map<String, String> specifications = new HashMap<>();
    private Map<String, Double> categories = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    public void setCategories(Map<String, Double> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public Map<String, Double> getCategories() {
        return categories;
    }

    private Product(ProductBuilder builder) {

        this.name = builder.name;
        this.categories = builder.categories;
        this.description = builder.description;
        this.imageUrl = builder.imageUrl;
        this.specifications = builder.specifications;
    }

    public static class ProductBuilder{

        //required
        private String name;
        private String description;

        //optional
        private Map<String, Double> categories = new HashMap<>();
        private String imageUrl;
        private Map<String, String> specifications = new HashMap<>();

        public ProductBuilder(String name, String description){
            this.name = name;
            this.description = description;
        }

        public ProductBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public ProductBuilder includeCategory(String categoryName, Double value) {
            this.categories.put(categoryName, value);
            return this;
        }

        public ProductBuilder includeSpecification(String specificationName, String description) {
            this.specifications.put(specificationName, description);
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
