package com.rad.ecommerceapi.services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("DBInitService")
@Transactional
public class DBInitServiceImpl implements DBInitService {
    @Override
    public void initUsers() {

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
