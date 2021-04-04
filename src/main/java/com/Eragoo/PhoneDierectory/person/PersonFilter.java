package com.Eragoo.PhoneDierectory.person;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Getter
@Setter
public class PersonFilter {
    private String name;
    private String surname;
    private List<Long> phoneIds;

    public Specification<Person> toPredicate() {
        return PersonSpecification.byNameLike(name)
                .and(PersonSpecification.bySurnameLike(surname))
                .and(PersonSpecification.byPhoneIds(phoneIds));
    }
}
