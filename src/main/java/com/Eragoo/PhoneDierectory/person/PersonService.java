package com.Eragoo.PhoneDierectory.person;

import com.Eragoo.PhoneDierectory.error.EntityNotFoundProblem;
import com.Eragoo.PhoneDierectory.phone.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PersonService {
    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;

    public PersonOutputDto save(PersonInputDto personInputDto) {
        Person person = new Person(personInputDto);
        personRepository.save(person);
        return new PersonOutputDto(person);
    }

    public PersonOutputDto getById(Long id) {
        return personRepository.findById(id)
                .map(PersonOutputDto::new)
                .orElseThrow(()-> new EntityNotFoundProblem("Person not found"));
    }

    public List<PersonOutputDto> getAll(PersonFilter personFilter) {
        return personRepository.findAll(personFilter.toPredicate())
                .stream()
                .map(PersonOutputDto::new)
                .collect(Collectors.toList());
    }

    public PersonOutputDto update(PersonInputDto personInputDto, Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundProblem("Person not found"));

        person.setName(personInputDto.getName());
        person.setSurname(personInputDto.getSurname());

        return new PersonOutputDto(person);
    }

    public void delete(Long id) {
        phoneRepository.deleteAllByPersonId(id);
        phoneRepository.deleteById(id);
    }
}
