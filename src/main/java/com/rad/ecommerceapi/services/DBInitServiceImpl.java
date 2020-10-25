package com.rad.ecommerceapi.services;

import com.rad.ecommerceapi.dao.UserRepository;
import com.rad.ecommerceapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service("DBInitService")
@Transactional
public class DBInitServiceImpl implements DBInitService {
    @Autowired private UserRepository userRepository;
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

    }

    @Override
    public void initProducts() {

    }
}
