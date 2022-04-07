package com.pervushin.com.javaTestTask.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ProductForms {

    @NotEmpty(message = "Пожалуйста, введите Наименование товара!")
    @Size(min = 2, max = 50, message = "Фамилия должна содержать от 2 до 20 символов!")
    private String nameProduct;

    @NotEmpty(message = "Пожалуйста, введите короткое наименование!")
    @Size(min = 1, max = 10, message = "Фамилия должна содержать от 2 до 20 символов!")
    private String shortNameProduct;

    @NotEmpty(message = "Пожалуйста, введите характеристики!")
    @Size(min = 1, max = 100, message = "Фамилия должна содержать от 2 до 20 символов!")
    private String specificationsProduct;

}
