package com.pervushin.com.javaTestTask.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class MovementOfProductForms {

    @NotEmpty(message = "Пожалуйста, введите дату!")
    private LocalDate dateOfMovement;

    @NotEmpty(message = "Пожалуйста, введите количество!")
    private Long quantityProducts;
}
