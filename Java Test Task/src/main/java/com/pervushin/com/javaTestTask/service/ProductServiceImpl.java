package com.pervushin.com.javaTestTask.service;

import com.pervushin.com.javaTestTask.entity.Product;
import com.pervushin.com.javaTestTask.forms.ProductForms;
import com.pervushin.com.javaTestTask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductForms productForm) {
        Product product = Product.builder()
                .nameProduct(productForm.getNameProduct())
                .shortNameProduct(productForm.getShortNameProduct())
                .specificationsProduct(productForm.getSpecificationsProduct())
                .build();
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Integer idProduct) {
        return productRepository.getById(idProduct);
    }

    @Override
    public void updateProduct(ProductForms productForm, Integer idProduct) {
        Product product = productRepository.getById(idProduct);
        product.setNameProduct(productForm.getNameProduct());
        product.setShortNameProduct(productForm.getShortNameProduct());
        product.setSpecificationsProduct(productForm.getSpecificationsProduct());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productRepository.deleteById(idProduct);

    }

}
