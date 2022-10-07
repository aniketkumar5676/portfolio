package com.order.order;

import com.order.order.Entity.Products;
import com.order.order.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProductApplication {

    @Autowired
    ProductRepo productRepo;


    @PostConstruct
    public void product() {

        List<Products> products = Stream.of(
                        new Products(1, "Chair", 220),
                        new Products(2, "Drone", 1900),
                        new Products(3, "Bed", 1220))
                       .collect(Collectors.toList());
        productRepo.saveAll(products);

    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

     @Bean

    public RestTemplate restTemplate(){
        return new RestTemplate();
}

}
