package com.Eragoo.PhoneDierectory.person;

import com.Eragoo.PhoneDierectory.phone.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "person")
    public List<Phone> phones;

    public Person(PersonInputDto personInputDto) {
        this.name = personInputDto.getName();
        this.surname = personInputDto.getSurname();
    }
}
