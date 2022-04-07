package com.pervushin.com.javaTestTask.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product", schema = "schema")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(nullable = false, unique = true)
    private String nameProduct;

    @Column(nullable = false, unique = true)
    private String shortNameProduct;

    @Column(nullable = false)
    private String specificationsProduct;

}