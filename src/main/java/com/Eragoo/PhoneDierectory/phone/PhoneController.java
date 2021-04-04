package com.Eragoo.PhoneDierectory.phone;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/phones")
@AllArgsConstructor
public class PhoneController {
    private final PhoneService phoneService;

    @GetMapping
    public List<PhoneOutputDto> getAll(PhoneFilter phoneFilter) {
        return phoneService.getAll(phoneFilter);
    }

    @PostMapping
    public PhoneOutputDto save(@Valid @RequestBody PhoneInputDto phoneInputDto) {
        return phoneService.save(phoneInputDto);
    }

    @GetMapping("/{id}")
    public PhoneOutputDto get(@PathVariable("id") Long id) {
        return phoneService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        phoneService.delete(id);
    }
}
