package com.rad.ecommerceapi;

import com.rad.ecommerceapi.services.DBInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApiApplication implements CommandLineRunner {

    @Autowired private DBInitService dbInitService;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dbInitService.initRoles();
        dbInitService.initUsers();
        dbInitService.initCategories();
        dbInitService.initProducts();
        dbInitService.initFavorites();
        dbInitService.initShoppingcarts();
        dbInitService.initShoppingcartItems();
        dbInitService.initOrders();
        dbInitService.initOrderItems();
    }
}
