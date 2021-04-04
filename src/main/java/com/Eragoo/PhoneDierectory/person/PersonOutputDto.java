package com.Eragoo.PhoneDierectory.person;

import com.Eragoo.PhoneDierectory.phone.PhoneSimpleOutputDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PersonOutputDto {
    private final Long id;
    private final String name;
    private final String surname;
    private final List<PhoneSimpleOutputDto> phones;

    public PersonOutputDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
        if (person.getPhones() != null) {
            this.phones = person.getPhones().stream()
                    .map(PhoneSimpleOutputDto::new)
                    .collect(Collectors.toList());
        } else {
            this.phones = null;
        }
    }
}
