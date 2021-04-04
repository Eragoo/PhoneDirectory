package com.Eragoo.PhoneDierectory.person;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public PersonOutputDto save(@Valid @RequestBody PersonInputDto personInputDto) {
        return personService.save(personInputDto);
    }

    @GetMapping("/{id}")
    public PersonOutputDto get(@PathVariable("id") Long id) {
        return personService.getById(id);
    }

    @PutMapping("/{id}")
    public PersonOutputDto update(@PathVariable("id") Long id, @RequestBody PersonInputDto personInputDto) {
        return personService.update(personInputDto, id);
    }

    @GetMapping
    public List<PersonOutputDto> getAll(PersonFilter filter) {
        return personService.getAll(filter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }
}
