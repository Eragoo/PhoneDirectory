package com.Eragoo.PhoneDierectory.phone;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

@Getter
@Setter
public class PhoneFilter {
    private Set<CountryCode> countryCodes;
    private String cellularOperatorNumber;
    private String body;
    private Set<Long> personIds;

    public Specification<Phone> toPredicate() {
        return PhoneSpecification.byBodyLike(body)
                .and(PhoneSpecification.byCellularOperatorNumberLike(cellularOperatorNumber))
                .and(PhoneSpecification.byCountryCodes(countryCodes))
                .and(PhoneSpecification.byPersonIds(personIds));
    }
}
