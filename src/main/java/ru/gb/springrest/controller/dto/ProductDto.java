package ru.gb.springrest.controller.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.apache.tomcat.jni.Status;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6,fraction = 2)
    private BigDecimal cost;
    @PastOrPresent
    private LocalDate manufactureDate;
    @NotNull
    private Status status;
}
