package com.Eragoo.PhoneDierectory.phone;

import com.Eragoo.PhoneDierectory.error.EntityNotFoundProblem;
import com.Eragoo.PhoneDierectory.person.Person;
import com.Eragoo.PhoneDierectory.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final PersonRepository personRepository;

    public List<PhoneOutputDto> getAll(PhoneFilter filter) {
        return phoneRepository.findAll(filter.toPredicate()).stream()
                .map(PhoneOutputDto::new)
                .collect(Collectors.toList());
    }

    public PhoneOutputDto save(PhoneInputDto inputDto) {
        Person person = personRepository.findById(inputDto.getPersonId())
                .orElseThrow(() -> new EntityNotFoundProblem("Person not found"));
        Phone phone = new Phone(inputDto, person);
        phoneRepository.save(phone);
        return new PhoneOutputDto(phone);
    }

    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }

    public PhoneOutputDto getById(Long id) {
        return phoneRepository.findById(id)
                .map(PhoneOutputDto::new)
                .orElseThrow(()-> new EntityNotFoundProblem("Phone not found"));
    }
}
