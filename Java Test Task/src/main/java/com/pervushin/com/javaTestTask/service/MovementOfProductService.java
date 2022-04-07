package com.pervushin.com.javaTestTask.service;

import com.pervushin.com.javaTestTask.entity.MovementOfProduct;
import com.pervushin.com.javaTestTask.forms.MovementOfProductForms;
import org.springframework.stereotype.Service;

@Service
public interface MovementOfProductService {

    void productReceipt(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement);

    void productScrapping(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement);

    MovementOfProduct getMovementOfProduct(Integer idMovement);

    void updateMovementOfProduct(MovementOfProductForms movementOfProductForms, Integer idMovement);

    void deleteMovementOfProduct(Integer idMovement);

    MovementOfProduct getMovement(Integer productId);

    MovementOfProduct getTheTotalQuantityInStock();

}
