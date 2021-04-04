package com.Eragoo.PhoneDierectory.phone;

import com.Eragoo.PhoneDierectory.person.Person;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class PhoneSpecification {
    public static Specification<Phone> byCountryCodes(Set<CountryCode> countryCodes) {
        return (r, cq, cb) -> isNotEmpty(countryCodes) ?
                r.get("countryCode").in(countryCodes) :
                null;
    }

    public static Specification<Phone> byPersonIds(Set<Long> personIds) {
        return (r, cq, cb) -> isNotEmpty(personIds) ?
                r.get("person").in(personIds) :
                null;
    }

    public static Specification<Phone> byCellularOperatorNumberLike(String cellularOperatorNumber) {
        return (r, cq, cb) ->  cellularOperatorNumber != null ?
                cb.like(r.get("cellularOperatorNumber"), cellularOperatorNumber) :
                null;
    }

    public static Specification<Phone> byBodyLike(String body) {
        return (r, cq, cb) ->  body != null ?
                cb.like(r.get("body"), body) :
                null;
    }
}
