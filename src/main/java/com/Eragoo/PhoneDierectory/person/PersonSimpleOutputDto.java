package com.Eragoo.PhoneDierectory.person;

import com.Eragoo.PhoneDierectory.phone.PhoneSimpleOutputDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PersonSimpleOutputDto {
    private final Long id;
    private final String name;
    private final String surname;

    public PersonSimpleOutputDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
    }
}
