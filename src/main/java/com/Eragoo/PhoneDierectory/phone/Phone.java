package com.Eragoo.PhoneDierectory.phone;

import com.Eragoo.PhoneDierectory.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Phone number +61 356 65-43-21 contains:
 * Country code: +61
 * Cellular operator number: 356
 * Body: 65-43-21
 */
@Entity
@Getter
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;
    private String cellularOperatorNumber;
    private String body;
    @ManyToOne
    private Person person;

    public Phone(PhoneInputDto phone, Person person) {
        this.countryCode = phone.getCountryCode();
        this.cellularOperatorNumber = phone.getCellularOperatorNumber();
        this.body = phone.getBody();
        this.person = person;
    }
}
