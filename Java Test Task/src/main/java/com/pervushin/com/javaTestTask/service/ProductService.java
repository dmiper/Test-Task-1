package com.pervushin.com.javaTestTask.service;

import com.pervushin.com.javaTestTask.entity.Product;
import com.pervushin.com.javaTestTask.forms.ProductForms;

public interface ProductService {

    void addProduct(ProductForms productForm);

    Product getProduct(Integer idProduct);

    void updateProduct(ProductForms productForm, Integer idProduct);

    void deleteProduct(Integer idProduct);

}
