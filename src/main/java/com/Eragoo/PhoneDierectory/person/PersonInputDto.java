package com.Eragoo.PhoneDierectory.person;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PersonInputDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
}
