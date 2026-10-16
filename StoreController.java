package com.codealpha.ecommerce;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class StoreController {
 private final ProductRepository products; private final OrderRepository orders;
 public StoreController(ProductRepository p,OrderRepository o){products=p;orders=o;}
 @GetMapping("/products") public List<Product> all(){return products.findAll();}
 @GetMapping("/products/{id}") public Product one(@PathVariable Long id){return products.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));}
 @PostMapping("/orders") public OrderRecord order(@RequestBody OrderRequest req){
  if(req.customerName==null||req.customerName.isBlank()||req.email==null||req.items==null||req.items.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name, email and cart items are required");
  double total=0;
  for(CartItem item:req.items){Product p=products.findById(item.productId).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unknown product"));
   if(item.quantity<1||p.stock<item.quantity) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid quantity or insufficient stock for "+p.name);
   total+=p.price*item.quantity;
  }
  for(CartItem item:req.items){Product p=products.findById(item.productId).orElseThrow();p.stock-=item.quantity;products.save(p);}
  OrderRecord o=new OrderRecord();o.customerName=req.customerName;o.email=req.email;o.total=total;
  o.itemsJson=req.items.toString(); return orders.save(o);
 }
 @GetMapping("/orders") public List<OrderRecord> orders(){return orders.findAll();}
 public static class OrderRequest {public String customerName;public String email;public List<CartItem> items;}
 public static class CartItem {public Long productId;public int quantity;public String toString(){return productId+":"+quantity;}}
 @Bean CommandLineRunner seed(ProductRepository repo){return args->{if(repo.count()==0){
  repo.save(new Product("Wireless Headphones","Comfortable wireless headphones with clear sound.",2499,"Electronics","https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=700",20));
  repo.save(new Product("Everyday Backpack","Durable backpack for college and travel.",1799,"Accessories","https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=700",15));
  repo.save(new Product("Smart Watch","Fitness tracking and notifications.",3299,"Electronics","https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=700",12));
  repo.save(new Product("Running Shoes","Lightweight shoes for daily workouts.",2899,"Fashion","https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=700",10));
 }};}
}