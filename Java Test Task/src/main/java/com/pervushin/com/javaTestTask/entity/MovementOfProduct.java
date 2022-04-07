package com.pervushin.com.javaTestTask.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movement_of_product", schema = "schema")
public class MovementOfProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovement;

    @Enumerated(value = EnumType.STRING)
    private Operation typeOfOperation;

    @ManyToOne
    @JoinColumn
    private Product idProduct;

    @Column(nullable = false)
    private LocalDate dateOfMovement;

    @Column(nullable = false)
    private Long quantityProducts;

    public enum Operation {
        ADMISSION, SALVATION
    }

}