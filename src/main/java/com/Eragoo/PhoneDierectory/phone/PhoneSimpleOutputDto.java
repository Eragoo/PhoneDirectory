package com.Eragoo.PhoneDierectory.phone;

import lombok.Getter;

@Getter
public class PhoneSimpleOutputDto {
    private final Long id;
    private final CountryCode countryCode;
    private final String cellularOperatorNumber;
    private final String body;

    public PhoneSimpleOutputDto(Phone phone) {
        this.id = phone.getId();
        this.countryCode = phone.getCountryCode();
        this.cellularOperatorNumber = phone.getCellularOperatorNumber();
        this.body = phone.getBody();
    }
}
