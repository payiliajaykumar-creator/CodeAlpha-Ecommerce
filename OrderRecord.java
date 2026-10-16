package com.codealpha.ecommerce;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="customer_orders")
public class OrderRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 public String customerName;
 public String email;
 @Column(length=5000) public String itemsJson;
 public double total;
 public String status="PLACED";
 public LocalDateTime createdAt=LocalDateTime.now();
 public OrderRecord() {}
}