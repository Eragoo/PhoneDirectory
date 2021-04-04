package com.Eragoo.PhoneDierectory.phone;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PhoneInputDto {
    @NotNull
    private CountryCode countryCode;
    @NotNull
    @Min(1)
    private String cellularOperatorNumber;
    @NotNull
    @Min(1)
    private String body;
    @NotNull
    private Long personId;
}
