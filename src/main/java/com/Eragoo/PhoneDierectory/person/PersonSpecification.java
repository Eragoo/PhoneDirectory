package com.Eragoo.PhoneDierectory.person;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class PersonSpecification {
    public static Specification<Person> byNameLike(String name) {
        return  (r, cq, cb) -> name != null ? cb.like(r.get("name"), name+"%") : null;
    }

    public static Specification<Person> bySurnameLike(String surname) {
        return  (r, cq, cb) -> surname != null ? cb.like(r.get("surname"), surname+"%") : null;
    }

    public static Specification<Person> byPhoneIds(List<Long> phoneIds) {
        return  (r, cq, cb) -> isNotEmpty(phoneIds) ?
                r.join("phones").get("id").in(phoneIds)
                : null;
    }
}
