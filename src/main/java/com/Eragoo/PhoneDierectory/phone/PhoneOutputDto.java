package com.Eragoo.PhoneDierectory.phone;

import com.Eragoo.PhoneDierectory.person.PersonSimpleOutputDto;
import lombok.Getter;

@Getter
public class PhoneOutputDto {
    private final Long id;
    private final CountryCode countryCode;
    private final String cellularOperatorNumber;
    private final String body;
    private final String readablePhoneNumber;
    private final PersonSimpleOutputDto person;

    public PhoneOutputDto(Phone phone) {
        this.id = phone.getId();
        this.countryCode = phone.getCountryCode();
        this.cellularOperatorNumber = phone.getCellularOperatorNumber();
        this.body = phone.getBody();
        this.person = new PersonSimpleOutputDto(phone.getPerson());
        this.readablePhoneNumber = "+" + countryCode + "-" + cellularOperatorNumber + "-" + body;
    }
}
