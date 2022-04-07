package com.pervushin.com.javaTestTask.controller;

import com.pervushin.com.javaTestTask.entity.Product;
import com.pervushin.com.javaTestTask.forms.ProductForms;
import com.pervushin.com.javaTestTask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @PostMapping("http://localhost:8080/addProduct")
    public String addProduct(ProductForms productForms) {
        productService.addProduct(productForms);
        return "success";
    }

    @GetMapping("http://localhost:8080/getProduct")
    public String getProduct(Model model, Integer idProduct) {
        Product product = productService.getProduct(idProduct);
        model.addAttribute("success", product);
        return "success";
    }

    @PostMapping("http://localhost:8080/updateProduct")
    public String updateProduct(@Valid ProductForms productForm, Integer idProduct) {
        productService.updateProduct(productForm, idProduct);
        return "success";
    }

    @PostMapping("http://localhost:8080/deleteProduct")
    public String deleteProduct(Integer idProduct) {
        productService.deleteProduct(idProduct);
        return "success";
    }
}
