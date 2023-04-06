package br.com.person.project.person;

import br.com.person.project.person.DTO.PersonCreateDto;
import br.com.person.project.person.DTO.PersonDetailDto;
import br.com.person.project.person.DTO.PersonListDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService service){
        this.personService = service;
    }

    @GetMapping("/")
    public ResponseEntity<Page<PersonListDto>> list(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(personService.listPerson(pageable));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<PersonDetailDto> detail(@PathVariable @Valid Long id){
        Optional<PersonDetailDto> personDetailDto = personService.detailPerson(id);
        return personDetailDto.map(detailDto -> ResponseEntity.status(HttpStatus.OK).body(detailDto)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<PersonCreateDto> create(@RequestBody @Valid PersonCreateDto personCreateDto){
        PersonCreateDto createDto = personService.createPerson(personCreateDto);
        if (createDto != null) return new ResponseEntity<>(createDto, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<PersonCreateDto> update(@PathVariable Long id, @RequestBody @Valid PersonCreateDto personCreateDto){
        PersonCreateDto createDto = personService.updatePerson(id, personCreateDto);
        if (createDto != null) return new ResponseEntity<>(createDto, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PersonEntity>> search(@RequestParam(required = false) String name, Pageable pageable) {
        Page<PersonEntity> personEntityPage = personService.searchPerson(name, pageable);
        if(personEntityPage != null) {
            return new ResponseEntity<>(personEntityPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PersonEntity> delete(@PathVariable @Valid Long id){
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
