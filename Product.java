package com.codealpha.ecommerce;
import jakarta.persistence.*;
@Entity
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 public String name;
 @Column(length=2000) public String description;
 public double price;
 public String category;
 public String imageUrl;
 public int stock;
 public Product() {}
 public Product(String name,String description,double price,String category,String imageUrl,int stock) {
  this.name=name; this.description=description; this.price=price; this.category=category; this.imageUrl=imageUrl; this.stock=stock;
 }
}