package com.rad.ecommerceapi.services;

import com.rad.ecommerceapi.dao.CategoryRepository;
import com.rad.ecommerceapi.dao.ShoppingcartRepository;
import com.rad.ecommerceapi.dao.UserRepository;
import com.rad.ecommerceapi.entities.Category;
import com.rad.ecommerceapi.entities.Shoppingcart;
import com.rad.ecommerceapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service("DBInitService")
@Transactional
public class DBInitServiceImpl implements DBInitService {
    @Autowired private UserRepository userRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ShoppingcartRepository shoppingcartRepository;
    @Override
    public void initUsers() {
        for(int i = 0; i < 5; i++){
            User user = new User();
            user.setUsername("user"+(i+1));
            user.setFirstname("user"+(i+1)+"F");
            user.setLastname("user"+(i+1)+"L");
            if (new Random().nextInt(1) < 0.5) {
                user.setGender("male");
            } else {
                user.setGender("female");
            }
            user.setEmail("user"+(i+1)+"@example.com");
            user.setAddress("user"+(i+1)+" address");
            user.setPassword("123");
            if (new Random().nextInt(1) < 0.5) {
                user.setRole("user");
            } else {
                user.setRole("admin");
            }
            user.setTel("0000000000");
            userRepository.save(user);
        }
    }

    @Override
    public void initOrder() {

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
}
