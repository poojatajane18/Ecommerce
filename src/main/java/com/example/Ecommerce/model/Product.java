package com.example.Ecommerce.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	 @Id
	 private String id;
	 private String name;
	 private String description;
     private double price;
	 private List<String> categories;
	 public Product() {
	        this.ratings = new ArrayList<>(); // Initialize ratings list
	 }
	 
	 public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	private List<Map<String, Object>> attributes;
	 private Availability availability;
	 private List<Rating> ratings;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<Map<String, Object>> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Map<String, Object>> attributes) {
		this.attributes = attributes;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	 
	 
}
