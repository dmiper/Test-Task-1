package com.pervushin.com.javaTestTask.service;

import com.pervushin.com.javaTestTask.entity.MovementOfProduct;
import com.pervushin.com.javaTestTask.entity.Product;
import com.pervushin.com.javaTestTask.forms.MovementOfProductForms;
import com.pervushin.com.javaTestTask.repository.MovementOfProductRepository;
import com.pervushin.com.javaTestTask.repository.ProductRepository;
import org.springframework.stereotype.Component;

import static com.pervushin.com.javaTestTask.entity.MovementOfProduct.Operation.ADMISSION;
import static com.pervushin.com.javaTestTask.entity.MovementOfProduct.Operation.SALVATION;

@Component
public class MovementOfProductServiceImpl implements MovementOfProductService {

    private final MovementOfProductRepository movementOfProductRepository;
    private final ProductRepository productRepository;

    public MovementOfProductServiceImpl(MovementOfProductRepository movementOfProductRepository, ProductRepository productRepository) {
        this.movementOfProductRepository = movementOfProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void productReceipt(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement) {
        Product product = productRepository.getById(idProduct);
        MovementOfProduct movementOfProduct = MovementOfProduct.builder()
                .typeOfOperation(ADMISSION)
                .idProduct(product)
                .dateOfMovement(movementOfProductForms.getDateOfMovement())
                .quantityProducts(movementOfProductForms.getQuantityProducts())
                .build();
        movementOfProductRepository.save(movementOfProduct);
    }

    @Override
    public void productScrapping(MovementOfProductForms movementOfProductForms, Integer idProduct, Integer idMovement) {
        Product product = productRepository.getById(idProduct);
        MovementOfProduct movementOfProduct = MovementOfProduct.builder()
                .typeOfOperation(SALVATION)
                .idProduct(product)
                .dateOfMovement(movementOfProductForms.getDateOfMovement())
                .quantityProducts(movementOfProductForms.getQuantityProducts())
                .build();
        movementOfProductRepository.save(movementOfProduct);
    }

    @Override
    public MovementOfProduct getMovementOfProduct(Integer idMovement) {
        return movementOfProductRepository.getById(idMovement);
    }

    @Override
    public void updateMovementOfProduct(MovementOfProductForms movementOfProductForms, Integer idMovement) {
        MovementOfProduct movementOfProduct = movementOfProductRepository.getById(idMovement);
        movementOfProduct.setDateOfMovement(movementOfProductForms.getDateOfMovement());
        movementOfProduct.setQuantityProducts(movementOfProductForms.getQuantityProducts());
        movementOfProductRepository.save(movementOfProduct);
    }

    @Override
    public void deleteMovementOfProduct(Integer idMovement) {
        movementOfProductRepository.deleteById(idMovement);
    }

    @Override
    public MovementOfProduct getMovement(Integer idProduct) {
        return movementOfProductRepository.getTypeOfOperationByIdProduct(idProduct);
    }

    @Override
    public MovementOfProduct getTheTotalQuantityInStock() {
        return movementOfProductRepository.getTheTotalQuantityInStock();
    }
}
