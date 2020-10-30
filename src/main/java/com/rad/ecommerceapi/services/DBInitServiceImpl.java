package com.rad.ecommerceapi.services;

import com.rad.ecommerceapi.dao.*;
import com.rad.ecommerceapi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service("DBInitService")
@Transactional
public class DBInitServiceImpl implements DBInitService {
    @Autowired private UserRepository userRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ShoppingcartRepository shoppingcartRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private OrderRepository orderRepository;

    @Override
    public void initUsers() {
        for(int i = 0; i < 5; i++){
            User user = new User();
            user.setUsername("user"+(i+1));
            user.setFirstname("user"+(i+1)+"F");
            user.setLastname("user"+(i+1)+"L");
            if (Math.random() < 0.5) {
                user.setGender("male");
            } else {
                user.setGender("female");
            }
            user.setEmail("user"+(i+1)+"@example.com");
            user.setAddress("user"+(i+1)+" address");
            user.setPassword("123");
            if (Math.random() < 0.5) {
                user.setRole("user");
            } else {
                user.setRole("admin");
            }
            user.setTel("0000000000");
            userRepository.save(user);
        }
    }

    @Override
    public void initOrders() {
        for(int i = 0; i < 20; i++){
            Order order = new Order();
            order.setDate(new Date());
            order.setShipment(Math.random() < 0.5 ? true : false);
            order.setStatus("Pending");
            List<User> users = userRepository.findAll();
            order.setUser(users.get(new Random().nextInt(users.size())));
            order.setTotal(0);
            orderRepository.save(order);
        }

    }

    @Override
    public void initOrderItems() {
        orderRepository.findAll().forEach(order -> {
            productRepository.findAll().forEach(product -> {
                if(Math.random() < 0.3) {
                    OrderProduct orderItem = new OrderProduct();
                    orderItem.setOrder(order);
                    orderItem.setProduct(product);
                    orderItem.setQuantity(new Random().nextInt(6) + 1);
                    order.getOrderProducts().add(orderItem);
                    product.getOrderProducts().add(orderItem);
                    productRepository.save(product);
                    double subTotal = orderItem.getProduct().getPrice() * orderItem.getQuantity();
                    DecimalFormat df = new DecimalFormat("#.##");
                    subTotal = Double.valueOf(df.format(subTotal));
                    order.setTotal(order.getTotal() + subTotal);
                }
            });
            orderRepository.save(order);
        });
    }

    @Override
    public void initShoppingcarts() {
        userRepository.findAll().forEach((user -> {
            Shoppingcart shoppingcart = new Shoppingcart();
            shoppingcart.setUser(user);
            shoppingcartRepository.save(shoppingcart);
        }));
    }

    @Override
    public void initProducts() {
        double rangeMin = 10;
        double rangeMax = 500;
        for(int i=0; i < 10; i++){
            Product product = new Product();
            product.setName("Product " + (i+1));
            double generatedPrice = rangeMin + (rangeMax - rangeMin) * new Random().nextDouble();
            DecimalFormat df = new DecimalFormat("#.##");
            generatedPrice = Double.valueOf(df.format(generatedPrice));
            product.setPrice(generatedPrice);
            product.setDetails("This is product " + (i+1));
            product.setImage("product"+(i+1)+".jpg");
            List<Category> categories = categoryRepository.findAll();
            product.setCategory(categories.get(new Random().nextInt(categories.size())));
            productRepository.save(product);
        }
    }

    @Override
    public void initCategories() {
        for(int i = 0; i < 5; i++){
            Category category = new Category();
            category.setName("category"+(i+1));
            categoryRepository.save(category);
            int randomNbofChildrens = new Random().nextInt(3);
            for(int j = 0; j < randomNbofChildrens; j++){
                Category subcategory = new Category();
                subcategory.setName("categories"+(i+1) + " children" + (j+1));
                subcategory.setParent(category);
                categoryRepository.save(subcategory);
            }
        }
    }

    @Override
    public void initFavorites() {
        userRepository.findAll().forEach(user -> {
            productRepository.findAll().forEach(product ->  {
                if(Math.random() < 0.2){
                    user.getFavorites().add(product);
                    product.getFavorites().add(user);
                    userRepository.save(user);
                }
            });
        });

    }
}
