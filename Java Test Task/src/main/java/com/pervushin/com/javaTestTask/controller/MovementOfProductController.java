package com.pervushin.com.javaTestTask.controller;

import com.pervushin.com.javaTestTask.entity.MovementOfProduct;
import com.pervushin.com.javaTestTask.forms.MovementOfProductForms;
import com.pervushin.com.javaTestTask.service.MovementOfProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MovementOfProductController {

    private final MovementOfProductService movementOfProductService;

    @PostMapping("http://localhost:8080/addProductReceipt")
    public String addProductReceipt(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement) {
        movementOfProductService.productReceipt(movementOfProductForms, idProduct, idMovement);
        return "success";
    }

    @PostMapping("http://localhost:8080/addProductScrapping")
    public String addProductScrapping(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement) {
        movementOfProductService.productScrapping(movementOfProductForms, idProduct, idMovement);
        return "success";
    }

    @GetMapping("http://localhost:8080/getMovementOfProduct")
    public String getMovementOfProduct(Model model, Integer idMovement) {
        MovementOfProduct movementOfProduct = movementOfProductService.getMovementOfProduct(idMovement);
        model.addAttribute("success", movementOfProduct);
        return "success";
    }

    @GetMapping("http://localhost:8080/getMovement")
    public String getMovement(Model model, Integer productId) {
        MovementOfProduct movementOfProduct = movementOfProductService.getMovement(productId);
        model.addAttribute("success", movementOfProduct);
        return "success";
    }

    @PostMapping("http://localhost:8080/updateMovementOfProduct")
    public String updateMovementOfProduct(@Valid MovementOfProductForms movementOfProductForms, Integer idMovement) {
        movementOfProductService.updateMovementOfProduct(movementOfProductForms, idMovement);
        return "success";
    }

    @PostMapping("http://localhost:8080/getTheTotalQuantityInStock")
    public String getTheTotalQuantityInStock() {
        movementOfProductService.getTheTotalQuantityInStock();
        return "success";
    }

    @PostMapping("http://localhost:8080/deleteMovementOfProduct")
    public String deleteMovementOfProduct(Integer idMovement) {
        movementOfProductService.deleteMovementOfProduct(idMovement);
        return "success";
    }

}
