package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> findByAttributes(String key, Object value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("attributes." + key).is(value));
        return mongoTemplate.find(query, Product.class);
    }
}